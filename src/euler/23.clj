(ns euler.23
  (:use [euler.core]
        [criterium.core]))

(defn is-abundant? [num]
  (> (reduce + (sum-divisors num)) num))

;; Limit 20161
;; After 48, all even numbers are sum-abundent

(defn sum-abundent [20161]
  (reduce + (filter is-abundant? (range 1 limit))))
