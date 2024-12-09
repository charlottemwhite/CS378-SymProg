; mapr.clj         03 Dec 18; 03 May 19

; sinple mapreduce in Clojure

; (mapreduce identity + '(((a 3) (b 2) (c 1))
;                         ((b 7) (d 3) (c 5))))

; (mapreduce nutrition + '(hamburger bun cheese
;                          lettuce tomato mayo))

; given a list ((key value) ...) that is sorted by keys,
; combine values to form ((key value1 value2 ...) ...)
(defn combinekeysb [lst key subres result]
  (if (empty? lst)
      (cons (cons key subres) result)
      (if (= key (first (first lst)))
          (combinekeysb (rest lst)
                        key
                        (cons (second (first lst)) subres)
                        result)
          (combinekeysb lst
                        (first (first lst))
                        '()
                        (if key
                            (cons (cons key subres) result)
                            result)) ) ) )

(defn combinekeys [lst] (combinekeysb lst nil '() '()))

(defn mapreduce [mapfn reducefn lst]
  (let [rawresult (mapcat mapfn lst)]
    (let [sorted (sort (fn [x y] (compare (first x) (first y)))
                       rawresult)]
      (let [keyvals (combinekeys sorted)]
        (map (fn [lst] (list (first lst)
                             (apply reducefn (rest lst))))
             keyvals) ) ) ) )

; find nutrition for a given food item
; (nutrition 'bun)
(defn nutrition [food]
  (rest (assocl food
    '((hamburger (calories 80) (fat 8)
                 (protein 20))
      (bun (calories 200) (carbs 40) (protein 8)
           (fiber 4))
      (cheese (calories 100) (fat 15) (sodium 150))
      (lettuce (calories 10) (fiber 2))
      (tomato (calories 20) (fiber 2))
      (mayo (calories 40) (fat 5) (sodium 20)) ) )))

