(ns euler.core
  (:require [clojure.string :as str]
            [clojure.set :as set]) 
  (:use     [clojure.contrib.math]
            [clojure.contrib.lazy-seqs :only (primes)]))

;;;; General Math Functions

(defn square [num]
  "Returns the square of a given number"
  (* num num))

(defn is-prime? [n]
  "Returns true if given number is prime"
  (and (not= 0 (mod n 2))
       (zero? (count (filter #(zero? (rem n %)) (range 3 (inc (sqrt n)) 2))))))

(defn triangle-num [n]
  "Returns nth triangle number"
  (-> (square n) (+ n) (/ 2)))

(def triangles (lazy-cat [0] (map + triangles (iterate inc 1))))

(defn n-triangle-nums [n]
  (take n triangles))

(defn to-binary [num]
  "Converts given base 10 number to binary"
  (read-string  (Integer/toBinaryString num)))

(defn reverse-num [num]
  "Returns given number, reversed"
  (BigInteger. (str/reverse (str num))))

(defn is-palindrome? [input]
  "Returns true if given input is a palindrome"
    (let [forward (str input)
          reverse (str/reverse forward)]
      (= forward reverse)))

(def fib-seq
     (lazy-cat [0 1] (map + (rest fib-seq) fib-seq)))

(defn sumdigits [num]
  "Sums all the digits of a given number. 123 => 6"
  (->> num (str) (re-seq #"\d") (map read-string) (reduce +)))

(defn factorial [num]
  "Produces factorial of given number"
  (if (zero? num)
    1
    (* num (factorial (dec num)))))

(defn primes-to [n]
  (take-while #(< % n) primes))

(defn thorough-prime-factors [num]
  "Returns the prime factors of a given number. 20 => (5 2 2)"
  (loop [a (primes-to (inc (/ num 2)))
         number num 
         factorlist '()]
    (if (seq a)
      (if (zero? (mod number (first a))) 
        (recur a (/ number (first a)) (conj factorlist (first a)))
        (recur (rest a) number factorlist))
      factorlist)))

(defn prime-factors [num]
  "Returns the prime factors of a given number. 20 + (5 2)"
  (filter #(zero? (mod num %)) (primes-to (/ num 2))))

(defn divisors [num]
  "Returns a list of the Proper Divisors of given number"
  (filter #(zero? (mod num %)) (range 1 (inc (/ num 2)))))

(defn sum-divisors [num]
  (reduce + (divisors num)))

(defn inefficient-sum-divisors [num]
  "Returns sum of Proper Divisors (not including number itself)"
  (let [prime-factors (partition-by identity (thorough-prime-factors num))]
    (let [sum (reduce * (map #(if (> (count %) 1)
                                (-> (first %) (expt (inc (count %))) (dec) (/ (dec (first %))))
                                (inc (first %)))
                             prime-factors))]
      (if (= sum 1) 1 (- sum num)))))

(defn inefficient-divisors-count [num]
  "Multiplies exponents of prime divisors(each incremented by one) to give number of divisors"
  (reduce * (map inc (map count (partition-by identity (thorough-prime-factors num))))))

(defn divisors-count [n]
  "Returns total number of divisors of given number"
  (* 2 (count (filter #(zero? (rem n %)) (range 1 (Math/sqrt n))))))
