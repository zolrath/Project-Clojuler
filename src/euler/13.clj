(ns euler.13
  (:require [clojure.contrib.string :as str])
  (:use     [euler.core]
            [criterium.core]))

(defn solve13 []
  (reduce + (map read-string (str/split-lines (slurp "/users/furd/nums.txt")))))
