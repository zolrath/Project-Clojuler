(ns euler.12
  (:use [euler.core]
        [criterium.core]))

(defn solve12 []
  (loop [a 1]
    (if (>= (divisors-count (trinum a)) 499)
      (trinum a)
      (recur (inc a)))))

(defn solve12b []
  (for [a (range 1 100)
        dc (divisors-count (trinum a))
        :while (< dc 35)]
    a))
