Readme for Nort
================

Getting started with ClojureScript and figwheel: [link](https://github.com/bhauman/lein-figwheel/wiki/Quick-Start)

Install Leiningen: [link](https://leiningen.org/)

Running figwheel server: `lein figwheel` from within the root directory

Running figwheel repl from within emacs:
Start a Clojure REPL using the command `cider-jack-in`.
After the REPL starts, run the following commands:
```
(use 'figwheel-sidecar.repl-api)
(start-figwheel!)
(cljs-repl)
```
Evaluate functions should then work.

Build: `lein cljsbuild once dev`

Public link: http://nortcore-env.pppu5exyyy.us-east-1.elasticbeanstalk.com/
