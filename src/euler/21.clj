(ns euler.21
  (:use [euler.core]
        [criterium.core]))

(defn amicable? [a]
  "Returns true if given numbers divisors produce an amicable number"
  (let [b (sum-divisors3 a)]
    (and (not= a b) (= a (sum-divisors3 b)))))

(defn amicablepairs [limit]
  "returns list of all amicable pairs up to given limit"
  (filter amicable? (range 2 limit)))

(defn solve21 []
  (reduce + (amicablepairs 10000)))
