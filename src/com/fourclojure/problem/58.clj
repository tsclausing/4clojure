(ns com.fourclojure.problem.58
  "Function Composition")


(def my-solution
  (fn [& funcs]
    (fn [& args] (first (reduce #(list (apply %2 %)) args (reverse funcs))))))


(def solutions [my-solution])
