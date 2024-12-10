; restgram.clj     Gordon S. Novak Jr.          ; 04 Dec 20; 14 May 21
; 26 Apr 19; 08 Nov 19

; Natural Language Access to Restaurant Database

; (ask '(show me a good italian restaurant in palo-alto))
; (ask '(where can i get ice-cream in berkeley))
; (ask '(show me chinese restaurants rated above 2.5 in los-altos))
; (ask '(how many chinese restaurants are in los-altos))

; Note: lexicon parts-of-speech must be disjoint from grammar nonterminals.

; The lexicon restlex.lsp defines: restaurant kindfood city county area street

(deflexicon
 '(
    (a/an       (a an some))
    (i/you      (i you one we))
    (are/is     (are is))
    (direct-obj (me us))
    (get        (get find obtain give eat))
    (quality  (
              (good 2.5) 
      ))
    (question-word (what where))
    (restword (restaurant (restaurants restaurant)
              place places restaurants
      ))
    (streetb (el-camino-real (el-camino el-camino-real)))

; the following commented out: smalllex.clj
;   (kindfood   (american bakery chinese ice-cream))
;   (city       (palo-alto berkeley san-francisco))
;   (county     (santa-clara))
;   (area       (bay-area))
;   (restaurant (dennys-restaurant))
;   (street     (el-camino-real buchanan))
   ))

; Define grammar after defining lexicon.

(def grammar

'((command  ->  (show (direct-obj)) true)
  (command  ->  (tell (direct-obj)) true)
  (command  ->  (what is) true)
  (command  ->  (give (direct-obj)) true)
  
  (qual     ->  ((quality))      (restrictb '>= 'rating $1))
  (qualb    ->  (rated above (number))   (restrictb '>= 'rating $3))

  (resttype ->  (for ? (kindfood))     (restrict 'foodtype $2))
  (resttype ->  (that serves ? (qual)? (kindfood))     (restrict 'foodtype $4))

  (loc      ->  (in (city))             (restrict 'city $2))
  (loc      ->  (in (county))           (restrict 'county $2))
  (loc      ->  (in the ? (area))       (restrict 'area $3))
  (loc      ->  (on (street) in ? (city)?)           (restrict 'street $2))
  (loc      ->  (on (streetb) in ? (city)?)          (restrict 'street $2)) ; handle el-camino

  ;; command
  (s -> ((command) (a/an)? some ? (qual)? (resttype)? (restword) (loc)? (qual)? (resttype)? 
        food ? (qualb)? (loc)?)
        (retrieve 'restaurant) )

  ;; where
  (s -> (where can (i/you) (get) some ? (qual)? (resttype)? food ? (restword)? (loc)?)
        (retrieve 'restaurant))

  (s -> ((question-word) (are/is) (a/an)? some ? (qual)? (resttype)? (restword) (loc)? (qual)? (resttype)?
        food ? (qualb)? (loc)?)
        (retrieve 'restaurant) )

  ;; how many
  (s -> (how many (qual)? (resttype)? food ? (restword) are ? there ? (loc)?)
    (do (retrieve 'restaurant) (postpr '(length (quote $$)))) )

))

; thirty is defined in restqueries.clj
(defn testall []
  (doseq [sentence thirty]
    (println) (println sentence) (println (ask sentence)) (println) ) )