; test3b.clj     Simple test cases for assignment 3         ; 15 Oct 20

; a few equations for a circle
(def eqnsc
     '((= pi 3.1415926)
       (= diameter (* 2 radius))
       (= area (* pi (expt radius 2)))
       (= circumference (* pi diameter)) ) )

; try to find circumference given radius
(defn testsolveqnscc []
  (solveqnsc '() eqnsc '(radius) 'circumference) )

; answer to (testsolveqnscc) should be:
; ((= circumference (* pi diameter))
;  (= area (* pi (expt radius 2)))
;  (= diameter (* 2 radius))
;  (= pi 3.1415926))

; eqns here should be the result from the above
; (testfilc (testsolveqnscc))
(defn testfilc [eqns]
  (filtercode eqns '(circumference)) )

; answer to (testfilc (testsolveqnscc)) should be:
; ((= circumference (* pi diameter))
;  (= diameter (* 2 radius))
;  (= pi 3.1415926))

; answer to (solvecode 'rtoc eqnsc '(radius) 'circumference) should be:
; ("  public static double rtoc( double radius) {"
;  "    double pi=3.1415926;"
;  "    double diameter=2*radius;"
;  "    double circumference=pi*diameter;"
;  "    return circumference;"
;  "}")
