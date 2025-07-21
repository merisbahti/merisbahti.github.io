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
  (let [watcher (atom nil)
        watch-fn (fn [] (println "starting watcher")
                   (reset! watcher
                           (beholder/watch
                            (fn [{path :path type :type}]
                              (load-string (slurp "document.clj"))
                              (if
                               (not (= (str path) output-file))
                                (generate-html)
                                (println "skipping update to " (str path))))
                            "./")))]
    (.start (Thread.
             (fn []
               (reset! watcher (watch-fn)))))
    (let [input-atom (atom "")]
      (while
       (do (reset! input-atom (read-line))
           (println "type q to quit, read the following: " @input-atom)
           (not (= @input-atom "q")))
        (beholder/stop @watcher)))))
