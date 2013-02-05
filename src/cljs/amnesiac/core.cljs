(ns amnesiac.core
  (:require [goog.json :as json]
            [clojure.browser.repl :as repl]
            [domina]
            [domina.css :as css]
            [domina.events :as events]
            [one.browser.remote :as remote]))

(defn save-card
  "Sends a new question and answer to server to be saved."
  []
  (let [q (css/sel "#question")
        a (css/sel "#answer")
        content (clj->js {:question (domina/value q)
                          :answer   (domina/value a)})]
    (remote/request :request-card-id "/cards"
                    :method "POST"
                    :headers {"Content-Type" "application/json"}
                    :content (json/serialize content))
    (domina/set-value! q "")
    (domina/set-value! a ""))
  (events/unlisten! (css/sel "#save-card"))
  (domina/set-styles! (domina/by-id "add-card-widget") {:display "none"}))

(defn add-card
  "Displays textareas and submit button for adding a new card"
  []
  (domina/set-styles! (domina/by-id "add-card-widget") {:display "inline"})
  (events/listen! (css/sel "#save-card") :click #(save-card)))

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
  (events/listen! (css/sel "#add-card") :click #(add-card))
  (events/listen! (css/sel "#next") :click #(request-card))
  (repl/connect "http://localhost:9000/repl"))
