(defn sum-divisors3 [n]
  (let [limit (Math/sqrt n)]
    (loop [i 2
           sum 1]
      (cond
       (= i limit) (+ i sum)
       (> i limit) sum
       (zero? (rem n i)) (recur (inc i) (+ sum i (/ n i)))
       :else             (recur (inc i) sum)))))

(defn sum-divisorsAB [num]
  "Returns sum of Proper Divisors (not including number itself)"
  (let [prime-factors (partition-by identity (thorough-prime-factors num))
        sum (reduce * (for [[p :as ps] prime-factors]
                        (if (> (count ps) 1)
                          (-> (apply * p ps)
                              (dec)
                              (/ (dec p)))
                          (inc p))))]
    (if (= sum 1) 1 (- sum num))))


(defn divisors [num]
  "Returns a list of the Proper Divisors of given number"
  (filter #(zero? (mod num %)) (range 1 (inc (/ num 2)))))

(defn sum-divisors [num]
  (reduce + (divisors num)))

(defn sum-divisorsA [num]
  "Returns sum of Proper Divisors (not including number itself)"
  (let [prime-factors (partition-by identity (thorough-prime-factors num))]
    (let [sum (reduce * (map #(if (> (count %) 1)
                                (-> (first %) (expt (inc (count %))) (dec) (/ (dec (first %))))
                                (inc (first %)))
                             prime-factors))]
      (if (= sum 1) 1 (- sum num)))))

