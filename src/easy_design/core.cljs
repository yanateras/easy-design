(ns easy-design.core
  (:require [reagent.core :as r]
            [quil.core :as q :include-macros true]))

(def forms #{:circle :square :triangle})
(def state (atom {:shapes [{:color [255 0 0] :form :square :position [600 0] :rotation 0.785 :size 100}]}))

(defn render
  [{:keys [color form position rotation size]}]
  (assert (contains? forms form))
  (apply q/fill color)
  (apply q/stroke color)
  (q/with-rotation [rotation]
    (let [[x y] position]
      (case form
        :circle (q/ellipse x y size size)
        :square (q/rect x y size size)))))

(defn draw
  []
  (q/background 255)
  (mapv render (:shapes @state)))

(q/defsketch canvas
  :host "canvas"
  :draw draw
  :size [js/window.innerWidth js/window.innerHeight])

(defn root []
  [:div {:style "display:none"}
   [:input {:type "color"}]
   [:button "circle"]
   [:button "square"]
   [:button "triangle"]])

(defn ^:export run []
  (r/render [root]
            (js/document.getElementById "container")))
