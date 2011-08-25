(ns euler.18
  (:use [euler.core]
        [criterium.core]))

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
  (slurp-triangle "triangle.txt"))
