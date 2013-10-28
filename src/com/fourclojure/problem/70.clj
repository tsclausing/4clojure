(ns com.fourclojure.problem.70
  "Word Sorting:
   Write a function that splits a sentence up into a sorted list of words. Capitalization should not affect sort order
   and punctuation should be ignored."
  (:require clojure.string))


(def my-solution
  (fn [sentence]
    (let [words (clojure.string/split sentence #"[^\w]")]
      (sort #(apply compare (map clojure.string/lower-case [%1 %2])) words)))
)


(def solutions [my-solution])
