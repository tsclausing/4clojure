(ns com.fourclojure.problem.166
  "Comparisons")


(def my-solution
  (fn [less-than x y]
    (cond
      (less-than x y) :lt
      (less-than y x) :gt
      :else :eq))
)


(def solutions [my-solution])
