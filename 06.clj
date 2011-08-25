(ns euler.06
  (:use [euler.core]
        [criterium.core]))

(defn square-of-sum [limit]
  (square (reduce + (range 1 (inc limit)))))

(defn sum-of-squares [limit]
  (reduce + (map square (range 1 (inc limit)))))

(defn solve06 []
  (- (square-of-sum 100) (sum-of-squares 100)))
