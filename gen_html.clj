(ns gen-html
  (:require
   [hiccup.page :refer [html5]]
   [nextjournal.beholder :as beholder]))

(def output-file "index.html")

(defn generate-html []
  (require '[document :refer [document]] :reload-all :reload)
  (resolve 'document)
  (spit output-file (str (html5 (eval 'document)))))

(defn watch [_]
  (generate-html)
  (->
   (fn [] (beholder/watch
           (fn [{path :path}]
             (let [path (str path)]
               (println "update detected at " path)
               (if
                (not (= path output-file))
                 (generate-html)
                 (println "skipping update to " path)))) "./"))
   Thread.
   .start)
  (let [input-atom (atom "")]
    (while
     (do (reset! input-atom (read-line))
         (println "type q to quit, read the following: " @input-atom)
         (not (= @input-atom "q"))))))
