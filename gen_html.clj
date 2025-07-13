(ns gen-html
  (:require [hiccup2.core :as h]))

(defn main [] (println (str (h/html [:b "hi"]))))
