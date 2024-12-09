; backch.clj      08 Oct 18

; version of backchain that separates rules and facts
; (backchain 'e '((c a b) (e c d)) '(a b d))
(defn backchain [goal rules facts]
 (or (member goal facts)
     (some (fn [rule]
            (and (= (first rule) goal)
                 (every (fn [premise]
                          (backchain premise rules facts))
                        (rest rule))))
           rules)) )

(def clauses '((a) (b) (d) (c a b) (e c d)) )

(defn backch [literal]
  (some (fn [clause]
          (and (= literal (first clause))
               (every backch (rest clause))))
        clauses))
