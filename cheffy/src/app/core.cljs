(ns app.core
  (:require [reagent.dom]
            [re-frame.core :as rf]
            [app.db]
            [app.theme :refer [cheffy-theme]]
            ["@smooth-ui/core-sc" :refer [Normalize Button ThemeProvider]]))

(defn app
  []
  [:<>
   [:> Normalize]
   [:> ThemeProvider {:theme cheffy-theme}
    [:> Button "oHello ok okdeoois!"]]])

(defn ^:dev/after-load start
  []
  (rf/dispatch-sync [:initialize-db])
  (reagent.dom/render [app] (js/document.getElementById "app")))

(defn ^:export init
  []
  (start))
