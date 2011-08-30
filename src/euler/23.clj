(ns euler.23
  (:use [euler.core]
        [criterium.core]
        [clojure.set]))

(defn is-abundant? [num]
  (> (sum-divisors num) num))

(defn is-abundant?b [num]
  (> (inefficient-sum-divisors num) num))
;; CONFUSED AS HELL
;; Why is sum-divisors so much faster when performed by itself, but
;; when used on a range, my slower sum-dividers becomes... faster?
;; Limit 20161
;; After 48, all even numbers are sum-abundent

(defn abundantlist [start end]
  (filter is-abundant? (range start end)))

(defn abundantlistb [start end]
  (filter is-abundant?b (range start end)))


(defn abundantsums []
  (let [list (for [a (abundantlist 1 200)
                   b (abundantlist 1 (inc a))]
               (+ a b))]
    (set list)))

(defn nonabundant []
  (difference (set (doall (range 1 500))) (abundantsums)))
