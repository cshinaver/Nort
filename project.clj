(defproject hello-seymore "0.1.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.908"]
                 [reagent "0.8.1"]
                 [jarohen/chord "0.8.1"]
                 [cider/piggieback "0.4.0"]
                 [quil "2.6.0"]
                 ]
  :plugins [[lein-figwheel "0.5.13"]
            [lein-cljsbuild "1.1.7"]]
  :profiles {:dev {:source-paths ["src"]
                   :dependencies [[cider/piggieback "0.4.0"]
                                  [figwheel-sidecar "0.5.18"]]
                   :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}}}
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
