(ns euler.55
  (:require [clojure.string :as str])
  (:use [euler.core]
        [criterium.core]))

(defn is-lychrel? [num]
  "Returns true if number never produces palindrome"
  (loop [number (+ num (reverse-num num))
         iteration 0]
    (if (< iteration 50)
      (if (is-palindrome? number)
        true
        (recur (+ number (reverse-num number)) (inc iteration)))
      false)))

(defn solve55 []
  (count (remove is-lychrel? (range 1 10000))))
