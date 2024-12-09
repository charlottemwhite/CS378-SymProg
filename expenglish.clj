(defn op  [x] (first x))
(defn lhs [x] (second x))
(defn rhs [x] (third x))

(defn op->english [op]
  (list 'the
      (second (assocl op '((+ sum)
                          (- difference)
                          (* product)
                          (/ quotient)
                          (sin sine)
                          (cos cosine)))) 'of))

(defn exp->english [x]
  (if (cons? x)                ; operator?
      (append
        (op->english (op x))
        (append (exp->english (lhs x))
                (if (null? (rest (rest x)))      ; unary?
                    '()
                    (cons 'and
                          (exp->english (rhs x)) ) ) ) )
      (list x) ) )             ; leaf: operand
