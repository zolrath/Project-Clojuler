(ns euler.18
  (:use [euler.core]
        [criterium.core])
  (:require [clojure.contrib.io :as io]))

(defn slurp-triangle [file]
  (for [line (line-seq (io/reader file))]
    (map #(Integer/parseInt %) (re-seq #"[\d.]+" line))))

; Ended up stealing this implementation while looking into how to
; parse files properly. It's so elegant, how could I not?!
(defn merge-rows [row-n row-n-1]
  (map (fn [a [b c]] (+ a (max b c)))
       row-n-1
       (partition 2 1 row-n)))
 
(defn max-path [triangle]
  (reduce merge-rows (reverse triangle)))

(defn solve18 []
  (max-path (slurp-triangle "src/euler/txt/triangle.txt")))

