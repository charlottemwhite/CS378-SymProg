;     nav.lsp           G. Novak               02 Nov 18

; Examples and stubs for Navigation by Deductive Synthesis

; Edit this code to fill in the stubs

; execute the following first:
; (setq si::*multiply-stacks* 50)  ;  make runtime stack larger
; (load "cs378/onlisp.lisp")
; (load "cs378/onlispfix.lisp")
; (load "cs378/navrules.lsp")
; (load "cs378/nav.lsp")
; (load "cs378/utmtrans.lsp")

; some simple examples to test basic conversions

; what is the cartesian version of xyvar?  (xyvar itself)
; (inf (cartesian 'xyvar ?z) (print ?z))

; what is the cartesian version of rthvar?
; (inf (cartesian 'rthvar ?x) (print ?x))

; what is the distance between two rthvars?
; (inf (distance 'rthvar 'rthvar2 ?d) (print ?d))

; what is the distance between an rthvar and lat-long?
; (inf (distance 'rthvar 'llvar ?d) (print ?d))

; find the distance from an xy point a to a rth point b
; execute (test1) to get the result.  Ignore the @.
(defun test1 ()
  (<- (xy-data 'a))                      ; type of input var a
  (<- (rth-data 'b))                     ; type of input var b
  (<- (program1 ?d) (distance 'a 'b ?d)) ; program1 is distance from a to b
  (do-program 'program1 '(a b))          ; do inference and make the program
)

; test case for program1
; (program1 '(10 10) (list 30 (/ pi 6)))    ; = 16.7446934

; program2: move from point c by amount d to arrive at f.
; what is the distance from e to f?
(defun test2 ()
  (<- (xy-data 'c))                      ; c is a point
  (<- (rth-data 'd))                     ; d is a r-theta distance
  (<- (xy-data 'e))                      ; e is a point
  (<- (movefrom 'c 'd 'f))               ; move from c by d to arrive at f
  (<- (program2 ?d) (distance 'f 'e ?d)) ; what is the distance from f to e
  (do-program 'program2 '(c d e))
)

; (program2 '(4 3) (list 5 (/ pi 6)) '(6 8))    ; = 3.417527

; program3: move from point g by amount h to arrive at k.
; move from point k by amount i to arrive at l.
; what is the distance from l to j?
(defun test3 ()
  (<- (xy-data 'g))
  (<- (rth-data 'h))
  (<- (rb-data 'i))
  (<- (xy-data 'j))
  (<- (movefrom 'g 'h 'k))  ; move from point g by amount h to arrive at k.
  (<- (movefrom 'k 'i 'l))  ; move from point k by amount i to arrive at l.
  (<- (program3 ?d) (distance 'l 'j ?d))  ; what is the distance from l to j?
  (do-program 'program3 '(g h i j))
)

; (program3 '(4 3) (list 5 (/ pi 6)) '(5 30) '(6 8))    ; = 5.165219

; program4: distance between cities m and n
(defun test4 ()
  (<- (city 'm))
  (<- (city 'n))
  (<- (program4 ?d) (distance 'm 'n ?d))    ; distance in meters between cities
  (do-program 'program4 '(m n)))

; (program4 'austin 'dallas)    ; = 290726.2719

; distance between a range-bearing point and a distance-direction point.
(defun test5 ()
;  add rules for inputs p and q and program
 (do-program 'program5 '(p q))    ; do inference and make the program
)
; (program5 '(10 60) '(12 NE))   ;  = 3.4896707137814036 (checked)

; program6: A trip starts at a city and travels a specified distance-direction.
; Find the bearing from the resulting position to another city.
(defun test6 ()
;  add rules for inputs r s u and program
  (do-program 'program6 '(r s u))
)
; (program6 'austin '(70000 W) 'san-antonio)   ; = 179.1213

; program7: A helicopter starts at Austin and flies 80000 meters
; at bearing 20 to pick up a clue; then it flies 100000 meters NW
; and picks up a treasure. Find the range and bearing to take
; the treasure to Dallas
(defun test7 ()
;  add rules for inputs v w x y and program
  (do-program 'program7 '(v w x y))
)
; (program7 'austin '(80000 20) '(100000 NW) 'dallas)
;   = (186156.121384753 45.331381413000368)

; program8: range and bearing from one city to another city
(defun test8 ()
;  add rules for inputs v y and program
  (do-program 'program8 '(v y)))
)

; (program8 'austin 'waco)  ; = (150576.87131283034 22.254882151769804)
; (program8 'austin 'dallas) ; = (290726.27195112398 17.834911296485687)
