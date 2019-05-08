(ns nort-core.draw
  (:require [quil.core :as q :include-macros true]
            [nort-core.utils :refer [log]]))

(defn draw []
  "Draw function called on each frame of the sketch"
  (let [r 50
        circle-part (/ Math/PI 30)
        current-radians (* (mod (q/frame-count) 30) circle-part)
        x (+ 150 (* r (Math/cos current-radians)))
        y (+ 150 (* r (Math/sin current-radians)))]
    (q/ellipse x y 55 55)
    ))

(defn setup []
  "Sets up sketch"
  ; Sets frame rate at 30
  (q/frame-rate 30)
  (q/background 255)
  (q/fill 0))

(defn render-sketch []
  (q/defsketch hello
    :setup setup
    :draw draw
    :host "hello"
    :size [300 300]))
