(ns euler.core
  (:require [clojure.string :as str]
            [clojure.set :as set]) 
   (:use    [clojure.contrib.math]))

;;;; General Math Functions

(defn sq [num]
  "Returns the square of a given number"
  (* num num))

(defn divisors [num]
  "Returns a list of the divisors of given number"
  (filter #(zero? (mod num %)) (range 1 (inc (/ num 2)))))

;;;; Prime Numbers

(defn is-prime? [n]
  "Returns true if given number is prime"
   (zero? (count (filter #(zero? (rem n %)) (range 3 n 2)))))

;;;; Other Functions

(defn trinum [num]
  (/ (+ (sq num) num) 2))

(defn to-binary [num]
  "Converts given base 10 number to binary"
  (read-string  (Integer/toBinaryString num)))

(defn reverse-num [num]
  (BigInteger. (str/reverse (str num))))
(defn is-palindrome? [input]
  "Returns true if given input is a palindrome"
    (let [forward (str input)
          reverse (str/reverse forward)]
      (= forward reverse)))

