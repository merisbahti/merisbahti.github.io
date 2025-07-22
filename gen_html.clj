(ns gen-html
  (:require
   [hiccup.page :refer [html5]]
   [nextjournal.beholder :as beholder]))

(def output-file "index.html")

(defn generate-html []
  (require '[document :as doc] :reload-all :reload)
  (resolve 'doc/document)
  (spit output-file (str (html5 (eval 'doc/document)))))

(defn watch []
  (generate-html)
  (->
   (fn [] (beholder/watch
           (fn [{path :path type :type}]

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
