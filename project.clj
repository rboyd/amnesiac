(defproject amnesiac "0.1.0-SNAPSHOT"
  :description "Amnesiac: Spaced repetition software"
  :url "http://github.com/rboyd/amnesiac"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/google-closure-library "0.0-2029"]
                 [org.clojure/google-closure-library-third-party "0.0-2029"]
                 [domina "1.0.1"]
                 [org.clojure/clojurescript "0.0-1576"]
                 [compojure "1.1.5"]
                 [com.novemberain/monger "1.4.2"]]
  :plugins [[lein-ring "0.8.2"]
            [lein-cljsbuild "0.3.0"]]
  :source-paths ["src/clj"
                 "src/cljs"]
  :ring {:handler amnesiac.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}}
  :cljsbuild
  {:builds
   [{:source-paths ["src/cljs"],
     :compiler
     {:pretty-print true,
      :output-to "resources/public/amnesiac.js",
      :optimizations :whitespace}}]})
