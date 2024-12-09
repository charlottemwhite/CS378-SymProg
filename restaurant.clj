; load files for restaurant example                  20 Nov 20; 29 Apr 24

; (load-file "cs378/restaurant.clj")
; (load-files)
; (gramcom grammar)
; (ask '(where can i get american food in palo-alto))
; (ask '(where can i get ice-cream in berkeley))

(def thirty nil)       ; to prevent Clojure error
(or (function? ask) (defn ask [sent] nil) )  ; stub

(defn load-files []
(load-file "cs378/cs378.clj")
(load-file "cs378/atn.clj")
(load-file "cs378/gramcom.clj")
(load-file "cs378/restgram.clj") ; starter grammar with small lexicon
(load-file "cs378/restlex.clj")  ; the big lexicon, remove for testing
(load-file "cs378/db.clj")
(load-file "cs378/restdb.clj")
)
