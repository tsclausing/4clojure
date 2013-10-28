(ns com.fourclojure.problem.70
  "Word Sorting:
   Write a function that splits a sentence up into a sorted list of words. Capitalization should not affect sort order
   and punctuation should be ignored."
  (:require clojure.string))


(def my-solution
  (fn [sentence]
    (let [words (re-seq #"\w+" sentence)]
      (sort-by clojure.string/lower-case words)))
)


(def solutions [my-solution])
