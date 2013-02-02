(ns amnesiac.core
  (:require [clojure.browser.repl :as repl]
            [domina]
            [domina.css :as css]
            [domina.events :as events]))


(defn main
  "The program's entrypoint"
  []
  (js/alert "amnesiac")
  (events/listen! (css/sel "#next") :click (fn [evt] (js/alert "next button clicked!")))
  (repl/connect "http://localhost:9000/repl"))
