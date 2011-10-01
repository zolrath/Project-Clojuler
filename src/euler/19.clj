(ns euler.19
  (:use [euler.core]
        [criterium.core]
        [date-clj]))

(defn sunday? [month year]
  (-> (date :day 1 :month (dec month) :year year) (is? :sunday)))

(defn solve19[]
  "Returns number of months between 1901-2000(inclusive) on which the first
   of the month is a Sunday."
  (let [result (for [years (range 1901 2001)
                     months (range 1 13)
                     :when (sunday? months years)]
                 1)]
    (reduce + result)))
