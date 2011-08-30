(ns euler.12
  (:use [euler.core]
        [criterium.core]))

(defn solve12 []
  (loop [a 1]
    (if (>= (divisors-count (triangle-num a)) 500)
      (triangle-num a)
      (recur (inc a)))))

; Stolen from internet. Uses lazy-seq. Need to learn to use these properly!
(first (filter #(> (divisors-count %) 500) triangles))
