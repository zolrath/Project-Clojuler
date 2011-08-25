(ns euler.09
  (:use [euler.core]
        [criterium.core]))

 (defn solve09 []
   "Finds the product abc of the Pythagorean triplet where a + b + c = 1000"
      (for [c (range 5 500)
         b (range 4 500)
         a (range 3 500)
         :when (and (= (square c) (+ (square b) (square a)))
                    (< a b c))]
       (if (= (+ a b c) 1000)
        (* a b c))))

