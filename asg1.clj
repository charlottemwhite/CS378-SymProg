; CS 378 Assignment 1 Recursion, Lists, and Trees
; Charlotte White
; cmw4856

; GitHub repository: https://github.com/charlottemwhite/CS378-Symbolic-Programming-Assignments


;; ====  2a) Add numbers in a list in recursive style. ==== 

; sum (lst)
; Return the sum of numbers in lst.
(defn sum [lst]
  (if (empty? lst)
    0
    (+ (first lst) (sum (rest lst))))
)

;; ====  2b) Add numbers in a list in tail-recursive style. ==== 

; sumtr-helper (lst, acc)
; Helper function for sumtr.
(defn sumtr-helper [lst acc]
    (if (empty? lst)
        acc
        (recur (rest lst) (+ acc (first lst)))
    )
)

; sumtr (lst)
; Return the sum of numbers in lst.
(defn sumtr [lst]
    (sumtr-helper lst 0)
)

;; ====  2c) Add numbers in a list using reduce. ==== 

; sumr (lst)
; Return the sum of numbers in lst.
(defn sumr [lst]
    (reduce + lst)
)


; sumsq (lst)
; Return the sum of squares in lst.
(defn sumsq [lst]
    (if (empty? lst)
        0
        (+ (expt (first lst) 2) (sumsq (rest lst))))
)

;; 3b) Add the squares of lst in tail-recursive style.

; sumqtr-helper (lst, acc)
; Helper function for sumsqtr
(defn sumsqtr-helper [lst acc]
    (cond
        (empty? lst) acc
        (not (number? (first lst))) nil
        :else (recur (rest lst) (+ acc (* (first lst) (first lst))))
    )
)

; sumsqtr (lst)
; Sum the square roots of lst.
(defn sumsqtr [lst]
    (sumsqtr-helper lst 0)
)

;; ==== 3c) Add the squares of lst using map reduce. ====

; sumsqmr (lst)
; Return the sum of squares in lst.
(defn sumsqmr [lst]
    (reduce + (map #(expt % 2) lst))
)

;; ====  4) Find the standard deviation of the numbers in lst. ==== 

; stdev (lst)
; Return the standard deviation of lst.
(defn stdev [lst]
    ; sqrt (variance = (sum xi^2/n) - (mean^2)
    (let [n (count lst)
        mean (if (zero? n) 0 ((reduce + lst) / n))
        mean-square (/ (reduce + (map #(Math/pow % 2) lst)) n)
        variance (- mean-square (Math/pow mean 2))]
    (Math/sqrt variance))
)

;; ==== 5a) Find the union of two sets. ====

; union-helper (lst, acc)
; Helper function for union.
(defn union-helper [lst acc] ; accumulated items so far.
    (if (empty? lst)
        acc
        (let [current (first lst)
            rest (rest lst)]
        (recur rest
            (if (contains? acc current) ; does acc contains current
                acc
                (conj acc current) ; add current to acc
            ) 
        ))
    )
)

; union (lsta, lstb)
; Return the set that is the union of lsta and lstb.
(defn union [lsta lstb]
    (union-helper (concat lsta lstb) #{}) ; #{} is empty set (no items seen thus far.)
)

;; ====  6) Produce a list of binomial coefficients. ==== 

; next-row (row)
; Generate the next row of Pascal's triangle. Helper function for binomial.
(defn next-row [row]
    (let [new-row (concat [0] row [0])] 
        ; use mapv to apply function (+) to new-row.
        ; first arg is new-row except last item.
        ; second arg is new-row except first item.
        (mapv + (butlast new-row) (rest new-row))
    )
) 

; binomial (n)
; Generate an nth-level Pascal's triangle.
(defn binomial [n]
    (loop [current-row [1] k 0] 
        (if (= k n)
            current-row  ; Return the current row when index equals n
            (recur (next-row current-row) (inc k))
        )
    ) 
) 

;; ====  7) Find the maximum in a binary tree. ==== 

; maxbt (tree)
; Return the maximum value of a binary tree.
(defn maxbt [tree]
    (cond
        (number? tree) 
            tree ; if tree is a number.

        (and (seq? tree) (not (empty? tree)))  ; check if tree is empty
            (let [
                first-val (maxbt (first tree))  ; find max in the first subtree
                rest-val (maxbt (rest tree))    ; find max in the rest of the tree
            ]  
            (max first-val rest-val))  ; return the max
    
        :else -999999 ; invalid tree
    )    
)

;; ====  8) Return a set of variables in an expression. ==== 

; vars (expr)
; Return the set of variables in an expression (list).
(defn vars [expr]
    (cond
        (number? expr) #{}

        (symbol? expr) #{expr}

        (list? expr)
            (let [left-vars  (vars (lhs expr))
                right-vars (vars (rhs expr))]
            (union left-vars right-vars))

        :else #{}
    )
)

;; ====  9) Return whether the item occurs in tree. ==== 

; occurs (item, tree)
; Return whether item occurs in tree.
(defn occurs [item tree]
    (cond
        (= item tree) true
        
        (list? tree) (loop [elements tree]
            (cond
            (empty? elements) 
                false

            (occurs item (first elements))
                true

            :else (recur (rest elements))))
        
        :else false)
)


;; ====  10) Evaluate an expression tree. ==== 

(defn myeval [tree]
  (if (cons? tree)
    (if (= (first tree) '*)
      (* (myeval (lhs tree) ) (myeval (rhs tree) ) )
      (if (= (first tree) '+)
        (+ (myeval (lhs tree) ) (myeval (rhs tree) ) )
        (if (= (first tree) '-)
          (if (empty? (rhs tree) )
            (- (myeval (lhs tree) ) )
            (- (myeval (lhs tree) ) (myeval (rhs tree) ) ) )
          (if (= (first tree) '/)
            (/ (myeval (lhs tree) ) (myeval (rhs tree) ) )
            (if (= (first tree) 'expt)
              (expt (myeval (lhs tree) ) (myeval (rhs tree) ) ) ) ) ) ) )
    tree ) )

; Returns the evaluation of the given expression and allowing variables
(defn myevalb [tree bindings]
  (if (cons? tree)
    (if (= (first tree) '*)
      (* (myevalb (lhs tree) bindings) (myevalb (rhs tree) bindings) )
      (if (= (first tree) '+)
        (+ (myevalb (lhs tree) bindings) (myevalb (rhs tree) bindings) )
        (if (= (first tree) '-)
          (if (empty? (rhs tree) )
            (- (myevalb (lhs tree) ) )
            (- (myevalb (lhs tree) bindings) (myevalb (rhs tree) bindings) ) )
          (if (= (first tree) '/)
            (/ (myevalb (lhs tree) bindings) (myevalb (rhs tree) bindings) )
            (if (= (first tree) 'expt)
              (expt (myevalb (lhs tree) bindings) (myevalb (rhs tree) bindings) ) ) ) ) ) )
    (if (number? tree)
      tree
      (second (assocl tree bindings) ) ) ) )


; returns  string that is a line of Java Code given an expression tree
(defn tojavab [tree]
  (if (cons? tree)
    (if (= (first tree) '*)
      (str (tojavab (lhs tree) ) " " (op tree) " " (tojavab (rhs tree) ) )
      (if (= (first tree) '+)
        (str '\( (tojavab (lhs tree)) " " (op tree) " " (tojavab (rhs tree) ) '\) )
        (if (= (first tree) '-)
          (if (empty? (rhs tree) )
            (str '\( (- (tojavab (lhs tree) )'\) ) )
            (str '\( (tojavab (lhs tree) ) " " (op tree) " " (tojavab (rhs tree) '\) ) ) )
          (if (= (first tree) '/)
            (str (tojavab (lhs tree) ) " " (op tree) " " (tojavab (rhs tree) ) )
            (if (= (first tree) '=)
              (str (tojavab (lhs tree) ) " " (op tree) " " (tojavab (rhs tree) ) )
              (str "Math." (op tree) "(" (tojavab (lhs tree) ) ")" ) ) ) ) ) )
      tree) )

(defn tojava [tree]
  (str (tojavab tree) ";") )

;; ====  5b) Find the difference of two sets. ==== 

; set-difference-helper (a, b, acc)
; Helper function for set-difference.
(defn set-difference-helper [a b acc]
  (if (empty? a)
    acc
    (let [current (first a)
        rest (rest a)]
    (recur rest
        b
        (if (occurs b current)
            acc
            (conj acc current))))
    )
)

; set-difference (lsta, lstb)
; Return the set that is the difference of lsta and lstb.
(defn set-difference [lsta lstb]
    (let [lstb-set (into #{} lstb)] ; convert to set
        (filter (fn [item] (not (contains? lstb-set item))) lsta)
    )
)