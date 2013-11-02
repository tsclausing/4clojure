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


(def recursive-map-solution
  ; inspired by user darren's solution
  (fn [formula]
    (fn [value-map]
      ((fn compute [part]
         (if (sequential? part)
           (apply ({'+ + '- - '* * '/ /} (first part)) (map compute (rest part)))
           (value-map part part)))
       formula)))
)


(def solutions [my-solution
                recursive-map-solution])
