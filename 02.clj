(ns euler.02
  (:use [euler.core]
        [criterium.core]))

(defn solve02 [] 
  (reduce + (filter even? (take-while #(< % 4000000) fib-seq))))
