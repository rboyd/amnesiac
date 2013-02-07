(ns amnesiac.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [amnesiac.db :as db]))

(defroutes app-routes
  (GET "/" [] (resp/resource-response "index.html" {:root "public"}))
  (GET "/cards/random" [] (->
                            (db/random-card)
                            resp/response))
  (POST "/cards" request {:status 200 :body (->
                                              (:body request)
                                              slurp
                                              db/save-card
                                              str)})
  (route/resources "/"))

(def app
  (handler/site app-routes))
