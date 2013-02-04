(ns amnesiac.db
  (:require [monger.core :as mg])
  (:require [monger.collection :as mgc])
  (:import [org.bson.types ObjectId]))

(mg/connect!)
(mg/set-db! (mg/get-db "test"))

(defn random-card
  "Fetches random card text from the database."
  []
  (:text (rand-nth (mgc/find-maps "cards"))))
