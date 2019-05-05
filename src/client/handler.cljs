(ns client.handler
  (:require [chord.client :refer [ws-ch]]
            [cljs.core.async :refer [<! >! put! close!]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

;; We use Chord to communicate with websocket endpoints - https://github.com/jarohen/chord

;; From the Documentation:
;; Chord only has one function, chord.client/ws-ch, which takes a web-socket URL
;; and returns a map, containing either :ws-channel or :error. When the connection
;; opens successfully, this channel then returns a two-way channel that you can
;; use to communicate with the web-socket server.

;; Asynchronously executes a call to the websocket endpoint, /echo, which will
;; hit the backend with a message that is printed to the backend's stout.
(defn client-echo []
  (go
    (let [{:keys [ws-channel error]} (<! (ws-ch "ws://localhost:5000/echo"))]
      (if-not error
        (>! ws-channel "Hello server from client!")
        (js/console.log "Error:" (pr-str error))))))

; (client-echo)
