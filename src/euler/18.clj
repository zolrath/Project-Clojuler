(ns euler.18
  (:use [euler.core]
        [criterium.core])
  (:require [clojure.contrib.io :as io]))

(def triangle
(slurp "/users/furd/triangle.txt")) 

(with-open [rdr (io/reader "/users/furd/triangle.txt")]
(reduce conj [] (line-seq rdr)))

(io/with-in-reader (io/file "/users/furd/triangle.txt") (read) (read))

(defn merge-rows [row-n row-n-1]
  (map (fn [a [b c]] (+ a (max b c)))
       row-n-1
       (partition 2 1 row-n)))
 
(defn max-path [triangle]
  (reduce merge-rows (reverse triangle)))
 
(defn slurp-triangle [filepath]
  (with-open [fr  (-> filepath java.io.File. java.io.FileReader.)
              fbr (java.io.BufferedReader. fr)]
    (doall (map (fn [s] (doall (map #(Integer/parseInt %) (.split s " ")))) (line-seq fbr)))))

(max-path
  (slurp-triangle "/users/furd/triangle.txt"))
