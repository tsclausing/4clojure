(ns com.fourclojure.problem.34
  "Implement range:
   Write a function which creates a list of all integers in a given range.")


(def solutions [#(take (- %2 %1) (iterate inc %1))])
