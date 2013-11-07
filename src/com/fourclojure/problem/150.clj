(ns com.fourclojure.problem.150
  "Palindromic Numbers")


(def my-solution
  (fn [start]
    (letfn [(palindrome? [number]
                         (let [str-num (str number)]
                           (= str-num (clojure.string/reverse str-num))))]
      (filter palindrome? (iterate inc start))))
)


(def solutions [my-solution])
