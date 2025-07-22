(ns gen-html
  (:require
   [hiccup.page :refer [html5]]))

(require '[babashka.pods :as pods])
(pods/load-pod 'org.babashka/fswatcher "0.0.5")
(require '[pod.babashka.fswatcher :as fw])

(def output-file "index.html")

(defn generate-html []
  (require '[document :as doc] :reload-all :reload)
  (resolve 'doc/document)
  (spit output-file (str (html5 (eval 'doc/document)))))

(defn watch []
  (generate-html)
  (->
   (fn [] (fw/watch "./"
                    (fn [{path :path}]
                      (if
                       (not (= path output-file))
                        (generate-html)
                        (println "skipping update to " path)))))
   Thread.
   .start)
  (let [input-atom (atom "")]
    (while
     (do (reset! input-atom (read-line))
         (println "type q to quit, read the following: " @input-atom)
         (not (= @input-atom "q"))))))
