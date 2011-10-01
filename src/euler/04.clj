(ns euler.04
  (:use [euler.core]
        [criterium.core]))

(defn solve04 []
  (let [product (for [x (range 100 1000)
                      y (range 100 x)]
                  (swank.core/break)
                  (* x y))]
    (apply max (filter is-palindrome? product))))
