(ns com.fourclojure.problem.121
  "Universal Computation Engine:
   Given a mathematical formula in prefix notation, return a function that calculates the value of the formula.

   Restrictions:
   - eval
   - resolve"
  (:require clojure.walk))


(def my-solution
  (fn [formula]
    (fn [value-map] (let [value-map (conj value-map {'+ + '- - '* * '/ /})]
      (clojure.walk/postwalk
        #(if (sequential? %)
          (let [leaf (replace value-map %)]
            (apply (first leaf) (rest leaf)))
          %)
        formula))))
)


(def solutions [my-solution])
