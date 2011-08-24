(ns euler.03
  (:use [euler.core]
        [criterium.core]
        [clojure.contrib.math]))

; Holy moly I didn't understand Clojure properly when I wrote this
(comment (defn prime-factor
  "Returns list of prime factors of given number"
  ([num]
    (prime-factor num (primes-to num) '()))
   ([mainnum primelist results]
      (let [currentprime (first primelist)]
      (if (or (empty? primelist) (< mainnum currentprime))
      results
      (if (zero? (mod mainnum currentprime))
        (prime-factor (/ mainnum currentprime) (rest primelist) (conj results currentprime))
        (prime-factor mainnum (rest primelist) results)))))))


(defn prime-factor [num]
  (filter #(zero? (mod num %)) (primes-to (sqrt num))))

(defn solve03 []
  (apply max (prime-factor 600851475143)))
