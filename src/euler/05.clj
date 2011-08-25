(ns euler.05
  (:use [euler.core]
        [criterium.core]))

(defn divto20 [num]
  (for [div (range 1 21)
        :when (= (mod num div) 0)]
    num))

(defn solve05 []
  (loop [num (* 19 17 13 11)]
    (if (= (count (divto20 num)) 20)
      num
      (recur (+ num (* 19 17 13 11))))))
