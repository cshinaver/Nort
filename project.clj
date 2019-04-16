(defproject hello-seymore "0.1.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.908"]
                 [reagent "0.8.1"]]
  :plugins [[lein-figwheel "0.5.13"]
            [lein-cljsbuild "1.1.7"]
            ]
  :clean-targets [:target-path "out" "static/js/main.js" "static/js/out"]
  :figwheel {
             :css-dirs ["static/css"]}
  :cljsbuild {
              :builds [{:id "dev"
                        :source-paths ["src"]
                        :figwheel true
                        :compiler {:main "nort-core.core"
                                   :output-dir "static/js/out"
                                   :output-to "static/js/main.js"
                                   }}]})
