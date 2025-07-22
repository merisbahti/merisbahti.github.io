(ns gen-html
  (:require
   [document :refer [document]]
   [hiccup.page :refer [html5]]
   [nextjournal.beholder :as beholder]))

(def output-file "index.html")
(defn generate-html []
  (println "generating" output-file)
  (spit output-file (str (html5 document))))

(defn watch []
  (generate-html)
  (->
   (fn [] (beholder/watch
           (fn [{path :path type :type}]
             (load-file "document.clj")
             (if
              (not (= (str path) output-file))
               (generate-html)
               (println "skipping update to " (str path))))
           "./"))
   Thread.
   .start)
  (let [input-atom (atom "")]
    (while
     (do (reset! input-atom (read-line))
         (println "type q to quit, read the following: " @input-atom)
         (not (= @input-atom "q"))))))
