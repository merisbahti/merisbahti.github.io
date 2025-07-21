(ns gen-html
  (:require
   [hiccup.page :refer [html5]]
   [hiccup2.core :as h]
   [nextjournal.beholder :as beholder]
   [document :refer [document]]))

(def output-file "index.html")
(defn generate-html []
  (println "generating " output-file)
  (spit output-file (str (html5 (h/html document)))))

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
    (Thread/sleep (* 24 60 60000))
    (when @watcher (beholder/stop @watcher))
    (println "thread dead")))

(defn main []
  (generate-html))
