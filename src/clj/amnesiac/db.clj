(ns amnesiac.db
  (:require [monger.core :as mg])
  (:require [monger.collection :as mgc])
  (:import [org.bson.types ObjectId]))

(mg/connect!)
(mg/set-db! (mg/get-db "test"))

(mgc/insert "documents" { :_id (ObjectId.) :first_name "John" :last_name "Lennon" })