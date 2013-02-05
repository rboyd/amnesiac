(ns amnesiac.db
  (:require [monger.core :as mg]
            [monger.collection :as mgc]
            [clojure.data.json :as json])
  (:import [org.bson.types ObjectId]))

(mg/connect!)
(mg/set-db! (mg/get-db "test"))

(defn random-card
  "Fetches random card text from the database."
  []
  (:question (rand-nth (mgc/find-maps "cards"))))

(defn save-card
  "Saves a new card to the database."
  [card-json]
  (let [card (json/read-str card-json)
        id (ObjectId.)
        q  (get card "question")
        a  (get card "answer")]
    (mgc/insert "cards" {:_id id :question q :answer a}))
  "OK")
