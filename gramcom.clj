; gramcom.clj           Gordon S. Novak Jr.       ; 04 Dec 20
; 29 Apr 19; 06 Nov 19; 09 Dec 19; 23 Dec 19; 20 Nov 20

; Grammar compiler for Clojure

(def dolvars '($1 $2 $3 $4 $5 $6 $7 $8 $9 $10 $11 $12 $13 $14 $15 $16))
(def failurept nil)
(def tracegram nil)
(def tracecomp nil)  ; trace when compiling each rule

; trace printout on entering a grammar rule
(defn gramtr [name rule]
  (println "trying" name rule)
  (println "   " atnsent))

; trace printout on leaving a grammar rule
(defn gramendtr [name res]
  (println "exit  " name res (if res atnsent))
  res)

(defn fourth [lst] (first (nthrest lst 3)))

; produce code for a rule item.  Item could be a word, (category), (nonterminal)
(defn itemcode [item]
  (if (cons? item)
      (if (or (cat? (first item))
              (= (first item) 'number)
              (= (first item) 'symbol))
          (list 'wordcat (kwote (first item)))
          item)
      (list 'and (list '= 'atnword (kwote item)) 'atnword)))

; code to test dv if qst is true
(defn qstcode [qst dv]
  (if qst
      (list 'if dv (list 'nextword))
      (list 'nextword)) )

; produce code for a rule.  Result is code list.
; lst   = remaining rule
; sem   = semantics
; n     = item number
; sflag = true if this is a sentence production (s -> ...)
(defn rulecode [lst sem n sflag]
  (if (empty? lst)
      sem
      (let [dv (nth dolvars n)
            itemc (itemcode (first lst))
            qst (and (not (empty? (rest lst)))
                     (= (second lst) '?))
            restcode (rulecode (if qst (rest (rest lst)) (rest lst))
                               sem (+ 1 n) sflag)
            cd
             (cons (if (or (empty? (rest lst))   ; test end of grammar list
                           (and qst (empty? (rest (rest lst)))))
                       (if (and (cons? (first lst))
                                (nonterm? (first (first lst))))
                           (if sflag
                               (list 'if (list 'empty? 'atnsent)
                                     (list 'do (list 'success) restcode)
                                     (list 'do (list 'def 'failurept 'atnsent)
                                           (list 'fail)))
                               (list 'do (list 'success) restcode))
                           (if sflag
                               (list 'do (qstcode qst dv)
                                     (list 'if (list 'empty? 'atnsent)
                                           (list 'do (list 'success) restcode)
                                           (list 'do
                                                 (list 'def 'failurept 'atnsent)
                                                 (list 'fail))))
                               (list 'do (qstcode qst dv)
                                     (list 'success) restcode)))
                       (if (and (cons? (first lst))
                                (nonterm? (first (first lst))))
                           restcode
                           (list 'do (qstcode qst dv) restcode)))
                   (if qst nil (list (list 'fail)))) ]
         (list 'let [dv itemc]
               (if qst
                   (first cd)
                   (cons 'if (cons dv cd)))) ) ) )

; compile one grammar rule to a function
; rule is (nonterm -> (list of items) semantics)
; returns function name
(defn rulecom [rule name]
 (do (if tracecomp (do (print "compiling ") (print name) (println rule)))
  (let [rcode (rulecode (third rule) (or (fourth rule) true)
                        0 (= (first rule) 's)) ]
    (let [code (if tracegram
                   (list 'defn name '[]
                         (list 'gramtr (list 'quote name)
                               (list 'quote rule))
                         (list 'saveptr)
                         (list 'gramendtr (list 'quote name) rcode) )
                   (list 'defn name '[]
                         (list 'saveptr)
                         rcode) ) ]
      (eval code))
      name )))

; compile a rule and print the result
(defn rulecompr [rule name]
  (let [rcode (rulecode (third rule) (or (fourth rule) 'true)
                        0 (= (first rule) 's)) ]
    (let [code (if tracegram
                   (list 'defn name '[]
                         (list 'gramtr (list 'quote name)
                               (list 'quote rule))
                         (list 'saveptr)
                         (list 'gramendtr (list 'quote name) rcode) )
                   (list 'defn name '[]
                         (list 'saveptr)
                         rcode) ) ]
      (println code))
      name ))

; compile a subrule for a nonterminal.  Returns list of subrule name.
(defn gramcoms [rule]
  (let [name (gensym (first rule))]
    (rulecom rule name)
    (list name) ))

(defn rulesfor [lst nonterm]
  (mapcat (fn [x] (if (= (first x) nonterm) (list x) '()))
          lst))

; compile the first rule in a list (unless in prev) and all with same name
(defn gramcomb [lst prev]
  (if (not (empty? lst))
      (if (member (first (first lst)) prev)
          (gramcomb (rest lst) prev)
          (let [rules (rulesfor lst (first (first lst))) ]
            (if (empty? (rest rules))
                (rulecom (first lst) (first (first lst)))
                (let [subrs (map gramcoms rules)
                     code (list 'defn (first (first lst)) '[]
                                (cons 'or subrs))]
                  (eval code)))
            (gramcomb (rest lst) (cons (first (first lst)) prev)) ) ) ) )

(defn gramcom [lst]
  (map (fn [x] (eval (list 'defn (first x) '[] nil))) lst)  ; define stubs
  (gramcomb lst '()))
