(ns com.fourclojure.problem.150
  "Palindromic Numbers")


;; reference functions

(defn int->seq
  "Convert an integer to a seq of digits"
  ([n] (int->seq n '()))
  ([n l] (let [l (conj l (rem n 10))]
           (if (> n 9) (recur (quot n 10) l) l))))

(defn seq->int [s]
  "Convert a seq of digits to an integer"
  (reduce #(+ (* 10 %1) %2) 0 s))


;; solution

(def solutions [])
