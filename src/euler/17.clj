(ns euler.17
  (:require [clojure.string :as str])
  (:use [euler.core]
        [criterium.core]))

(def lettermap {1 "one" 2 "two" 3 "three" 4 "four" 5 "five" 6 "six" 7 "seven" 8 "eight" 9 "nine" 10 "ten" 
                11 "eleven" 12 "twelve" 13 "thirteen" 14 "fourteen" 15 "fifteen" 16 "sixteen" 17 "seventeen"
                18 "eighteen" 19 "nineteen" 20 "twenty" 30 "thirty" 40 "forty" 50 "fifty" 60 "sixty" 70 "seventy"
                80 "eighty" 90 "ninety"})

(def countmap {0 0, 1 3, 2 3, 3 5, 4 4, 5 4, 6 3, 7 5, 8 5, 9 4, 10 3,
               11 6, 12 6, 13 8, 14 8, 15 7, 16 7, 17 9, 18 8, 19 8,
               20 6, 30 6, 40 5, 50 5, 60 5, 70 7, 80 6, 90 6})

(defn find-hundreds [num]
  "When passed a number ABC, returns A"
  (int (/ num 100)))

(defn find-tens [num]
  "When passed a number AB, returns A"
  (int (/ num 10)))

(defn separate-values [num]
  "If passed 342 => [3 40 2] for lettermap lookup"
  (let [hundreds (find-hundreds num)
        tens   (find-tens (- num (* hundreds 100)))
        ones (mod num 10)]
    (if (= tens 1)
      (let [tens (mod num 100)]
        [hundreds tens 0])
      [hundreds (* tens 10) ones])))

(defn english-num [num]
  "Returns natural language representation of given value between 1-999"
  (let [[hundreds tens ones] (separate-values num)]
    (str (if (> hundreds 0) (str (get lettermap hundreds) " hundred "))
         (if (and (> hundreds 0) (or (not= 0 tens) (not= 0 ones))) "and ") (get lettermap tens) " "
         (get lettermap ones))))

(defn english-num-actualcount [num]
  "Counts letters of natural language representation"
  (let [[hundreds tens ones] (separate-values num)]
    (count (str (if (> hundreds 0) (str (get lettermap hundreds) "hundred"))
                (if (and (> hundreds 0) (or (not= 0 tens) (not= 0 ones))) "and")(get lettermap tens)
                (get lettermap ones)))))

(defn english-num-count [num]
  "Uses countmap to get letter count for given number. Implemented to test speed difference vs counting length of a string"
  (let [[hundreds tens ones] (separate-values num)]
    (+ (if (> hundreds 0) (+ (get countmap hundreds) 7) 0)
       (if (and (> hundreds 0) (or (not= 0 tens) (not= 0 ones))) 3 0) (get countmap tens)
       (get countmap ones))))

(defn solve17 []
  "Solves via counting string length"
  (let [nums (for [x (range 1 1000)]
               (english-num-actualcount x))]
    (+ 11 (reduce + nums))))            ; add 11 for one thousand

(defn compare17 []
  "Solves via countmap lookup"
  (let [nums (for [x (range 1 1000)]
               (english-num-count x))]
    (+ 11 (reduce + nums)))) ; add 11 for one thousand
