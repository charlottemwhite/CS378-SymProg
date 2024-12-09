; physgram.clj         Gordon S. Novak Jr.           ; 23 Nov 20

; 05 Apr 04; 14 Apr 04; 22 Nov 05; 03 Dec 18; 28 Apr 19; 06 May 19; 06 Dec 19

; To run:
; (load-file "cs378/physics.clj")
; (load-files)
; (gramcom grammar)

; (phys '(what is the area of a circle with radius = 2))
; (phys '(what is the radius of a sphere with volume = 50))
; (phys '(what is the height of a fall with time = 4))
; (phys '(what is the power of a lift with mass = 50 and
;         height = 10 and time = 5))
; (phys '(how does the area of a circle vary with radius))
; (phys '(how does the force of gravitation vary with radius))
; (phys '(how does the area of a circle vary if radius is doubled))

(defn s []) ; stub

(defn number []
  (if (number? atnword)
       atnword))

(def lexicon
 '((propname (radius diameter circumference area
	      volume height velocity time
	      weight power height work speed mass))
   (a/an     (a an))
   (the/its  (the its))
   (objname  (circle sphere fall lift))
   (unitz    ((meter 1.0) (meters 1.0) (m 1.0)
              (inch 0.0254) (inches 0.0254) (in 0.0254) ) )
))  ; def lexicon

(defn objprops [])   ; to keep clojure happy

(def grammar '(
  (param     -> ((the/its)? (propname)) $2)
  (quantity  -> ((number)) $1)
  (object    -> ((a/an)? (objname) with (objprops))
                   (cons 'object (cons $2 $4)))
  (objprop   -> ((a/an)? (propname) of ? (quantity))  (list $2 $4))
  (objprop   -> ((propname) = (quantity)) (list $1 $3))
  (objprops  -> ((objprop) and (objprops))  (cons $1 $3))
  (objprops  -> ((objprop))  (list $1))
  (s         -> (what is (param) of (object)) (list 'calculate $3 $5))
))  ; def grammar

(def equations '(
(circle
  (= pi 3.1415926535)
  (= diameter (* 2 radius))
  (= circumference (* pi diameter))
  (= area (* pi (expt radius 2))) )

(sphere
  (= pi 3.1415926535)
  (= diameter (* 2 radius))
  (= circumference (* pi diameter))
  (= area (* 4 (* pi (expt radius 2))))
  (= volume (* (/ (* 4 pi) 3) (expt radius 3))) )

(fall
  (= gravity 9.80665)
  (= height   (* (/ gravity 2) (expt time 2)))
  (= velocity (* gravity time)) )

(lift
  (= gravity  9.80665)
  (= weight      (* gravity mass))
  (= work        (* weight height))
  (= speed       (/ height time))
  (= power       (* weight speed))
  (= power       (/ work time)) )
))  ; def equations

; find equations for topic
(defn findeqns [topic]
  (let [z (assocl topic equations)]
    (if (not (empty? z))
        (rest z)
        '())))

; find equation that relates specified vars
(defn findeqnsvars [eqns vars]
  (some (fn [eqn] (and (every (fn [x] (occurs x eqn))
			      vars)
		       eqn))
	eqns))

; approximate numeric equality
(defn approx= [x y] (< (Math/abs (- x y)) 0.0001))

; make a values list from vars, alist vals
; vars in alist have that value; others (except pi) are set to 1.0
; (valslist '(a pi b) '((b 2.0)))  =  ((a 1.0) (pi 3.1415926535) (b 2.0))
(defn valslist [vars vals]    ) ; stub to be filled in

; find how a variable of topic varies with another var
; (phys 'how does the force of gravitation vary with radius))
; (varywith 'gravitation 'force 'radius)  =  inverse-square
(defn varywith [topic var varyvar]    ) ; stub to be filled in

; find how a variable of topic varies with changes
; (phys '(how does the area of a circle vary if radius is doubled))
; (varychg 'circle 'area '((radius 2.0)))  =  4.0
(defn varychg [topic var changes]    ) ; stub to be filled in

(defn answerphys [qst]
  (if (= (first qst) 'list)
      (if (null? (rest qst))
          nil
          (cons (answerphys (second qst))
                (answerphys (cons 'list (rest (rest qst))))))
      (if (= (first qst) 'calculate)
	  (if (and (cons? (second qst))
		   (= (first (second qst)) '*))
	      (/ (solveqns (findeqns (second (rhs qst)))
			   (rest (rest (rhs qst)))
			   (lhs (second qst)) )
		 (rhs (second qst)) )
	      (solveqns (findeqns (second (rhs qst)))
			(rest (rest (rhs qst)))
			(second qst) ) )
	  (if (= (first qst) 'varywith)
	      (varywith (second qst) (third qst) (fourth qst))
	      (if (= (first qst) 'varychg)
		  (varychg (second qst) (third qst) (fourth qst))
		  (list 'bad 'semantics qst) ) ) ) ) )

; parse and answer physics questions
(defn phys [sentence]
  (def restrictions '())
  (def retrievals '())
  (initsent sentence)
  (let [qst (s)]
    (println qst)
    (answerphys qst) ) )

; parse and answer physics questions
(defn physb [sentence]
  (def restrictions '())
  (def retrievals '())
  (initsent sentence)
  (let [qst (s)]
    (println qst) ))
