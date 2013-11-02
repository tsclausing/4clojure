(ns com.fourclojure.problem.166
  "Comparisons:
   Write a function that takes three arguments, a less than operator for the data and two items to compare.
   The function should return a keyword describing the relationship between the two items (:lt :gt :eq).")


(def my-solution
  (fn [less-than x y]
    (cond
      (less-than x y) :lt
      (less-than y x) :gt
      :else :eq))
)


(def solutions [my-solution])
