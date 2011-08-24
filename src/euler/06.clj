(ns euler.06
  (:use [euler.core]
        [criterium.core]))

(defn squaretotal [limit]
  (square (reduce + (range 1 (inc limit)))))

(defn squarenums [limit]
  (reduce + (map square (range 1 (inc limit)))))

(defn square [num]
  (* num num))

(defn diffsquares [limit]
  (- (squaretotal limit) (squarenums limit)))

(defn sumdigits [num]
  (->> num (str) (re-seq #"\d") (vec) (map read-string) (reduce +)))
