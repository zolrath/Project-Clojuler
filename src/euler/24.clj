(ns euler.24
  (:use [euler.core]
        [criterium.core]))

(defn mutate []
  (for [a (range 10)
        b (range 10)
        c (range 10)
        d (range 10)
        e (range 10)
        f (range 10)
        g (range 10)
        h (range 10)
        i (range 10)
        j (range 10)
        :when (and (not= a b) (not= a c) (not= a d) (not= a e) (not= a f) (not= a g) (not= a h) (not= a i) (not= a j)
                   (not= b c) (not= b d) (not= b e) (not= b f) (not= b g) (not= b h) (not= b i) (not= b j)
                   (not= c d) (not= c e) (not= c f) (not= c g) (not= c h) (not= c i) (not= c j)
                   (not= d e) (not= d f) (not= d g) (not= d h) (not= d i) (not= d j)
                   (not= e f) (not= e g) (not= e h) (not= e i) (not= e j)
                   (not= f g) (not= f h) (not= f i) (not= f j)
                   (not= g h) (not= g i) (not= g j)
                   (not= h i) (not= h j)
                   (not= i j))]
    (str a b c d e f g h i j)))

;; Wanted to see if this would actually brute force it properly. It
;; did! Time to look into implementing a proper algorithm. This way
;; takes... a long time.

(defn bruteforcesolve24 []
  (nth (mutate) 999999))
