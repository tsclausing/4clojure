(ns com.fourclojure.problem.166
  "Comparisons")


(def my-solution
  (fn [less-than x y]
    (let [xy (less-than x y)
          yx (less-than y x)]
      (cond
        (= xy yx) :eq
        xy :lt
        :else :gt)))
)


(def solutions [my-solution])
