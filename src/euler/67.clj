(ns euler.67
  (:use [euler.18]))

(defn solve67 []
  (max-path (slurp-triangle "src/euler/txt/triangle2.txt")))
