(ns com.fourclojure.problem.38
  "Maximum value:
   Write a function which takes a variable number of parameters and returns the maximum value.

   Restrictions: max, max-key")


(def my-solution
  #(last (sort %&))
)


(def reduce-solution
  (fn [& values]
    (reduce #(if (> %1 %2) %1 %2) values))
)


(def recursive-solution
  (fn [& values]
    (loop [max (first values)
           values (rest values)]
      (if (seq values)
        (let [new-value (first values)]
          (recur
            (if (> new-value max) new-value max)
            (rest values)))
        max)))
)


(def solutions [my-solution
                reduce-solution
                recursive-solution])
