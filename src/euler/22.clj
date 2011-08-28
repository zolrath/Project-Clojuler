(ns euler.22
  (:use [euler.core]
        [criterium.core])
  (:require [clojure.contrib.io :as io]))

(defn slurp-names [filepath]
  (sort (re-seq #"\w+" (slurp "src/euler/txt/names.txt"))))

(defn score-letter [letter]
  "Gets int value of a char, subtracts 64 to make A 1, B 2 etc."
  (- (int letter) 64))

(defn score-name [name]
  (reduce + (map score-letter (seq name))))

(defn score-names []
  (let [namelist (slurp-names "src/euler/txt/names.txt")]
    (reduce + (map * (iterate inc 1) (map score-name namelist)))))
