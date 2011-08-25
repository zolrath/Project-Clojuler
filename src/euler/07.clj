(ns euler.07
  (:use [euler.core]
        [criterium.core]))

(defn nth-prime [n]
  (nth (filter is-prime? (range)) (dec n)))

(defn solve07 []
  "Lists the 10,001st prime number"
  (nth-prime 10001))
