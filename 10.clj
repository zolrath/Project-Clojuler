(ns euler.10
  (:use [euler.core]
        [criterium.core]))

(defn oldsolve10 []
  (reduce + (filter is-prime? (range 1 2000000 2))))

(defn solve10 []
  (reduce + (primes-to 2000000)))
