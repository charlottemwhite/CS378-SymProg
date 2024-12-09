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
    (a/an     (a an some))
    (i/you    (i you one we))
    (get      (get find obtain give))
    (quality  (
              (good 2.5) 
      ))
    (restword (restaurant (restaurants restaurant)
              (place (places place))
      ))

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

'((command  ->  (show me) true)
  (command  ->  (tell me) true)
  (command  ->  (what is) true)
  
  (qual     ->  ((quality))      (restrictb '>= 'rating $1))
  (qualb    ->  (rated above (number))   (restrictb '>= 'rating $3))

  (resttype ->  ((kindfood))     (restrict 'foodtype $1))

  (loc      ->  (in (city))      (restrict 'city $2))
  (loc      ->  (in (county))    (restrict 'county $2))
  (loc      ->  (in the ? (area))      (restrict 'area $3))

  ;; command
  (s -> ((command) (a/an)? (qual)? (resttype)? (restword) (qualb)? (loc)?)
        (retrieve 'restaurant) )

  ;; where
  (s -> (where can (i/you) (get) (qual)? (resttype)? food ? (loc)?)
        (retrieve 'restaurant))

  ;; how many
  (s -> (how many (qual)? (resttype)? food ? (restword) are ? there ? (loc)?)
    (do (retrieve 'restaurant) (postpr '(length (quote $$)))) )

))

; thirty is defined in restqueries.clj
(defn testall []
  (doseq [sentence thirty]
    (println) (println sentence) (println (ask sentence)) (println) ) )