(ns nort-core.core
  (:require [reagent.core :as r]
            [nort-core.utils :refer [log]]
            [nort-core.draw :as d]))

(defonce click-count (r/atom 0))

(defn my-p-tag []
  [:button
   {:on-click
    (fn []
      (swap! click-count inc)
      )}
   (str "yooooo hit me fam: click count == " @click-count)])

(defn on-connect [socket]
  (.send socket "I connected!")
  (.send socket "yay!")
  (.send socket "how exciting"))

(defn on-receive [event]
  (log (.-data event))
  (log event))

;(r/render [my-p-tag]
;          (.-body js/document))

;; Example web socket
(defn connect-to-websocket []
  (def example-socket (js/WebSocket. "ws://localhost:5000/echo"))
  (set! (.-onopen example-socket)
        #(on-connect example-socket))
  (set! (.-onmessage example-socket)
        on-receive))

; Uncomment to connect to websocket
; (connect-to-websocket)

; draw sketch
;(d/render-sketch)
