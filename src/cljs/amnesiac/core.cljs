(ns amnesiac.core
  (:require [clojure.browser.repl :as repl]
            [domina]
            [domina.css :as css]
            [domina.events :as events]
            [one.browser.remote :as remote]))

(defn replace-card
  "Replaces the current card with a newly selected card"
  [text]
  (domina/set-text! (domina/by-id "card-text") text))

(defn request-card
  "Request a new card from the server"
  []
  (remote/request :request-card-id "/cards/random"
                  :on-success #(replace-card (:body %))))

(defn main
  "The program's entrypoint"
  []
  (js/alert "amnesiac")
  (events/listen! (css/sel "#next") :click #(request-card))
  (repl/connect "http://localhost:9000/repl"))
