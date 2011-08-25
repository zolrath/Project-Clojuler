(ns euler.01
  (:use [euler.core]
        [criterium.core]))

(defn solve01 []
  (reduce + (filter #(or (zero? (mod % 3)) (zero? (mod % 5))) (range 1 1000))))
