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
  (int (/ num 100)))

(defn english-num [num]
  (loop [number num]
    ()))
