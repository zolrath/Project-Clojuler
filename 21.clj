(ns euler.21
  (:use [euler.core]
        [criterium.core]))

(defn sumdivisors [num]
  "Returns the sum of all divisors of given number"
  (reduce + (divisors num)))

(defn amicable? [a]
  "Returns true if given numbers divisors produce an amicable number"
  (let [b (sumdivisors a)]
    (and (not= a b) (= a (sumdivisors b)))))

(defn amicablepairs [limit]
  "returns list of all amicable pairs up to given limit"
 (filter amicable? (range 1 limit)))

(defn solve21 []
  (reduce + (amicablepairs 10000)))
