(ns nort-core.core
  (:require [reagent.core :as r]))

(defonce click-count (r/atom 0))

(defn my-p-tag []
  [:button
   {:on-click
    (fn []
      (swap! click-count inc)
      )}
   (str "yooooo hit me fam: click count == " @click-count)])

(r/render [my-p-tag]
          (.-body js/document))
