(ns euler.23
  (:use [euler.core]
        [criterium.core]
        [clojure.set]))

(defn is-abundant? [num]
  (> (sum-divisors num) num))

;; Limit 20161
;; After 48, all even numbers are sum-abundent

(defn abundantlist [start end]
  (filter is-abundant? (range start end)))

(defn abundantsumss []
  (let [list (for [a (abundantlist 1 20162)
                   b (abundantlist 1 (inc a))]
               (+ a b))]
    (set list)))

(defn nonabundant []
  (difference (set (doall (range 1 20162))) (abundantsums)))

(defn solve23 []
  (reduce + (nonabundant)))
