(ns amnesiac.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [amnesiac.db :as db]))

(defroutes app-routes
  (GET "/" [] (resp/resource-response "index.html" {:root "public"}))
  (GET "/stylesheets/main.css" [] (resp/resource-response "stylesheets/main.css" {:root "public"}))
  (GET "/amnesiac.js" [] (resp/resource-response "amnesiac.js" {:root "public"}))
  (GET "/images/prev.png" [] (resp/resource-response "/images/prev.png" {:root "public"}))
  (GET "/images/next.png" [] (resp/resource-response "/images/next.png" {:root "public"}))
  (GET "/cards/random" [] (resp/response (db/random-card)))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
