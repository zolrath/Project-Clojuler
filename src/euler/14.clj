(ns euler.14 
  (:use [euler.core]
        [criterium.core]))
(defn sq [num]
  (* num num))

(defn pascaltri [row]
  (loop [n row
         sub 1
         nums '()]
    (let [pascal (/ (* n (- n sub)) 2)]
      (if (=< n pascal)
        (recur pascal (inc sub) (conj nums pascal))
        nums))))

(defn pytrip []
  (for [a (range 3 500)
        b (range 4 500)
        c (range 5 500)
        :when (= (sq c) (+ (sq b) (sq a)))]
    (if (= (* a b c) 1000)
      (str "a: " a " b: " b " c: " c))
    ))
