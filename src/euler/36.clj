(ns euler.36
  (:require [clojure.contrib.string :as str])
  (:use [euler.core]
        [criterium.core]))

(defn is-binary-palindrome? [num]
  (and (palindrome? num)
       (palindrome? (to-binary num))))

(defn solve36 []
  (reduce + (filter is-binary-palindrome? (range 1 1000000))))
