(ns euler.17
  (:require [clojure.string :as str])
  (:use [euler.core]
        [criterium.core]))

(def lettermap {1 "one" 2 "two" 3 "three" 4 "four" 5 "five" 6 "six" 7 "seven" 8 "eight" 9 "nine" 10 "ten" 
                11 "eleven" 12 "twelve" 13 "thirteen" 14 "fourteen" 15 "fifteen" 16 "sixteen" 17 "seventeen"
                18 "eighteen" 19 "nineteen" 20 "twenty" 30 "thirty" 40 "forty" 50 "fifty" 60 "sixty" 70 "seventy"
                80 "eighty" 90 "ninty" 100 "hundred" 1000 "thousand"})

(defn char-to-digit [ch]
  "Converts a character representing a digit between 0 and 9 to the corresponding integer"
   (- (int ch) (int \0)))

(defn split-number [n factor]
  (->> (str n)
       (partition-all factor) ;; or partition
       (map (partial apply str))
       (map #(Integer/valueOf %))))

(defn find-hundreds [num]
  "When passed a number ABC, returns A"
  (int (/ num 100)))

(defn find-tens [num]
  "When passed a number AB, returns A"
   (int (/ num 10)))

(defn separate-values [num]
  (let [hundreds (find-hundreds num)
        tens   (find-tens (- num (* hundreds 100)))
        ones (- num (* hundreds 100) (* tens 10))]
    [hundreds tens ones]))


; Still need to add recognition of 1 in tens place for teens
(defn english-num [num]
  (let [[hundreds tens ones] (separate-values num)
        timestens (* tens 10)]
    (str (get lettermap hundreds) " hundreds " (get lettermap timestens) " " (get lettermap ones))))
