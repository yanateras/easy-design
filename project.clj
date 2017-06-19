(defproject easy-design "20160905"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.225"]
                 [quil "2.5.0"]
                 [reagent "0.6.0"]]
  :plugins [[lein-figwheel "0.5.8"]]
  :cljsbuild {
    :builds [{
        :id "easy-design"
        :source-paths ["src"]
        :figwheel {:on-jsload "easy-design.core/run"}
        :compiler {
          :main "easy-design.core"
          :asset-path "scripts"
          :output-dir "resources/public/scripts"
          :output-to "resources/public/script.js"}}]})
