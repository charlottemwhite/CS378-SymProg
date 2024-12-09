; print-tree.clj     Logan Persyn      14 Feb 22

; Useful tool for printing binary trees in Clojure.

; Majority of code copied from below, only added last couple of functions 
; to convert from tree structures discussed in class to tree structure used in source
; Source: https://codereview.stackexchange.com/questions/120369/printing-binary-trees

; put into cs378 class directory
; (load-file "cs378.clj")       ; load this first

; (cons-print-tree tree)        ; prints as a first-rest cons tree
; (cons-print-tree '((a b) (c d)))

; (op-print-tree tree)          ; prints as an op-lhs-rhs expression tree
; (op-print-tree '(= y (+ (* m x) b)))

(defn end-col
  "Returns one plus the maximum column occupied by the sparse string entry x."
  [x]
  (let [[[_ col] s] x]
    (+ col (count s))))

(defn min-corner
  "Returns a vector of the minimum non-empty row and column in sparse-string."
  [sparse-string]
  (mapv #(apply min (map % (keys sparse-string)))
        [first second]))

(defn max-corner
  "Returns a vector of one plus the maximum non-empty row and column in
  sparse-string."
  [sparse-string]
  (mapv #(apply max (map % sparse-string))
        [(comp inc first key) end-col]))

(defn fill
  "Returns a string of newlines and spaces to fill the gap between entries x and
  y in a sparse string whose minimum corner is corner."
  [corner x y]
  (let [[_ min-col] corner
        [[prev-row _] _] x
        [[next-row next-col] _] y]
    (apply str (concat (repeat (- next-row prev-row) \newline)
                       (repeat (- next-col
                                  (if (== prev-row next-row)
                                    (end-col x)
                                    min-col))
                               \space)))))

(defn sparse-str
  "Converts sparse-string to a string."
  [sparse-string]
  (let [corner (min-corner sparse-string)]
    (->> sparse-string
         (sort-by key)
         (cons [corner ""])
         (partition 2 1)
         (map (fn [[x y]] (str (fill corner x y) (val y))))
         (apply str))))

(defn shift
  "Creates and returns a sparse string by adding offset to the position of each
  entry in sparse-string."
  [offset sparse-string]
  (into {} (map (fn [[pos s]]
                  [(mapv + pos offset) s])
                sparse-string)))

(defn vert-gap
  "Returns the minimum vertical gap that can be used in combining the left and
  right tree strings."
  [left right]
  (if (and left right)
    (max 1 (quot (- (second (max-corner left))
                    (second (min-corner right)))
                 2))
    1))

(def directions {:left - :right +})

(defn diagonal
  "Returns a diagonal sparse string with the top end located at corner."
  [direction corner length character]
  (let [[first-row first-col] corner]
    (into {} (map (fn [n]
                    [[(+ first-row n)
                      ((directions direction) first-col n)]
                     (str character)])
                  (range length)))))

(defn leg
  "Returns a sparse string from shifting tree-string according to direction,
  vert-gap, and value-height, merged with a diagonal strut."
  [direction tree-string vert-gap value-height]
  (merge (shift [(+ value-height vert-gap)
                 ((directions direction) (inc vert-gap))]
                tree-string)
         (diagonal direction
                   [value-height ((directions direction) 1)]
                   vert-gap
                   ({:left \/ :right \\} direction))))

(defn assemble
  "Assembles a complete tree string from the tree strings of a value, left
  subtree, and right subtree."
  [value left right]
  (if (or left right)
    (let [[value-height _] (max-corner value)
          vert-gap (vert-gap left right)]
      (merge value
             (when left
               (leg :left left vert-gap value-height))
             (when right
               (leg :right right vert-gap value-height))))
    value))


"Creates and returns a tree string from node."
(defn tree-string [node]
    (let [{:keys [value left right]} node s (str value)]
        (apply assemble
            {[0 (- (quot (count s) 2))] s}
            (map #(when % (tree-string %))
                [left right]
            )
        )
    )
)

(defn rand-tree [weight depth]
    (into {:value (int (Math/pow 2 (rand (dec Integer/SIZE))))}
        (map #(when (and (pos? depth) (< (rand) weight))
                [% (rand-tree weight (dec depth))])
                [:left :right])
    )
)


; Added functions below to convert cons-trees and op-trees into same format as used above

(defn cons-tree-reformat [cons-tree]
    (if (cons? cons-tree)
        {:value '., :left (cons-tree-reformat (first cons-tree)), :right (cons-tree-reformat (rest cons-tree))}
        {:value cons-tree, :left nil, :right nil}
    )
)

(defn op-tree-reformat [op-tree]
    (if (cons? op-tree)
        {:value (op op-tree), :left (op-tree-reformat (lhs op-tree)), :right (if-not (= (rhs op-tree) nil) (op-tree-reformat (rhs op-tree)) nil)}
        {:value op-tree, :left nil, :right nil}
    )
)


; DON'T USE; Only use cons-print-tree or op-print-tree
(defn print-tree [tree]
    (println (sparse-str (tree-string tree)))
)

; Example of a "cons-tree" as defined in class
(def cons-test-tree '(((green eggs and) ((ham))) rocks (monster (((gold (monster)))))))

; Use to print cons-trees like example above
(defn cons-print-tree [tree]
    (print-tree (cons-tree-reformat tree))
)

; Example of an "op-tree" as defined in class, also called expresion trees
(def op-test-tree '(= x (* (+ a b) (- (+ (- c) d)))))

; Use to print op-trees like example above
(defn op-print-tree [tree]
    (print-tree (op-tree-reformat tree))
)

; EX:
;; (cons-print-tree cons-test-tree)
;; (op-print-tree op-test-tree)

