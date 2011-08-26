(ns euler.core
  (:require [clojure.string :as str]
            [clojure.set :as set]) 
   (:use    [clojure.contrib.math]))

;;;; General Math Functions

(defn square [num]
  "Returns the square of a given number"
  (* num num))

;;;; Prime Numbers

(defn is-prime? [n]
  "Returns true if given number is prime"
   (zero? (count (filter #(zero? (rem n %)) (range 3 (inc (sqrt n)) 2)))))

(defn primes-to [n]
  "Returns a list of all primes from 2 to n"
  (let [n (int n)]
    (let [root (int (Math/round (Math/floor (Math/sqrt n))))]
      (loop [i (int 3)
             a (int-array n)
             result (list 2)]
        (if (>= i n)
          (reverse result)
          (recur (+ i (int 2))
                 (if (< i root)
                   (loop [arr a
                          inc (+ i i)
                          j (* i i)]
                     (if (>= j n)
                       arr
                       (recur (do (aset arr j (int 1)) arr)
                              inc
                              (+ j inc))))
                   a)
                 (if (zero? (aget a i))
                   (conj result i)
                   result)))))))

(defn trinum [num]
  (/ (+ (square num) num) 2))

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

(def fib-seq
     (lazy-cat [0 1] (map + (rest fib-seq) fib-seq)))

(defn sumdigits [num]
  (->> num (str) (re-seq #"\d") (vec) (map read-string) (reduce +)))
(defn trinum [num]
  (/ (* num (inc num)) 2))

(defn factorial [num]
  (if (zero? num)
    1
    (* num (factorial (dec num)))))

(defn divisors [num]
  "Returns a list of the divisors of given number"
  (filter #(zero? (mod num %)) (range 1 (inc (/ num 2)))))

(defn prime-factors-of [num]
  (loop [a (primes-to (inc (sqrt num)))
        number num 
        factorlist ()]
    (if (seq a)
      (if (zero? (mod number (first a))) 
        (recur a (/ number (first a)) (conj factorlist (first a)))
        (recur (rest a) number factorlist))
      factorlist)))

(defn divisors-count [num]
  "Multiplies exponents of prime divisors(each incremented by one) to give number of divisors"
  (reduce * (map inc (map count (partition-by identity (prime-factors-of num))))))


