(defproject amnesiac "0.1.0-SNAPSHOT"
  :description "Amnesiac: Spaced repetition software"
  :url "http://github.com/rboyd/amnesiac"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/clojurescript "0.0-1450"]]
  :plugins [[lein-cljsbuild "0.3.0"]]
  :cljsbuild
  {:builds
   [{:source-paths ["src/cljs"],
     :compiler
     {:pretty-print true,
      :output-to "resources/public/amnesiac.js",
      :optimizations :whitespace}}]})
