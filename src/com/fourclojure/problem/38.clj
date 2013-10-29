(ns com.fourclojure.problem.38
  "Maximum value:
   Write a function which takes a variable number of parameters and returns the maximum value.

   Restrictions: max, max-key")


(def my-solution
  #(last (sort %&))
)


(def solutions [my-solution])
