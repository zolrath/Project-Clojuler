(ns euler.09
  (:use [euler.core]
        [criterium.core]))

(defn solve09 [] 
  "Finds the product of abc of the Pythagorean triplet where a+b+c = 1000"
  (for [a (range 1 1000)
        b (range a 1000)
        c [(- 1000 a b)]
        :when (= (+ (* a a) (* b b)) (* c c))]
    (* a b c)))
