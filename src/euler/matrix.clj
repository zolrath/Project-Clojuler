(ns euler.matrix
  (:use [euler.core]))

(defn make-matrix [vector width]
  )

(defn multiply-column [matrix augment]
  (let [results (for [m matrix
                      a augment]
                  (map #(map (fn [c d] (* c d))%1 %2) m a))]
    (vec (map vec (partition 2 results)))))
