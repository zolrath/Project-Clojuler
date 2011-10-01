(ns euler.26
  (:use [euler.core]
        [criterium.core]))

(defn num-list [limit]
  (remove #(or (zero? (mod % 2))
               (zero? (mod % 5))) (range 1 (inc limit))))
