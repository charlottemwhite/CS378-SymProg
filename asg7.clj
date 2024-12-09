;; (load-file "cs378/restaurant.clj")
(defn load-files-one []
(load-file "cs378.clj")
(load-file "atn.clj")
(load-file "gramcom.clj")
(load-file "db.clj")
)

(defn load-files-two []
(load-file "restgram.clj") ; starter grammar with small lexicon
(load-file "restlex.clj")  ; the big lexicon, remove for testing
(load-file "restdb.clj")
)

(load-files-one)
(def thirty nil)       ; to prevent Clojure error
(or (function? ask) (defn ask [sent] nil) )
(load-files-two)



; test gramm
(gramcom grammar) 

(ask '(where can i get american food in palo-alto)) 