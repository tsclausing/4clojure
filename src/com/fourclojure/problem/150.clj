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

(defn pal
  "Convert an integer into an even or odd length palindrome"
  ([i] (pal i false))
  ([i odd?] (let [s (int->seq i)
                  rs (reverse (if odd? (butlast s) s))]
              (+
                (* i (apply * (repeat (count rs) 10N)))
                (seq->int rs)))))

(defn palstr
  "Implementation of pal using string<->integer conversion"
  ([i] (palstr i false))
  ([i odd?] (let [s (str i)]
              (bigint (str i (clojure.string/join (reverse (if odd? (butlast s) s))))))))


;; solution

(def my-solution
  (fn [i]
    "Starting with i, return an infinite lazy sequence of palindromes")
)

(def solutions [my-solution])
