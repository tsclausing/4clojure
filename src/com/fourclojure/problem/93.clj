(ns com.fourclojure.problem.93
  "Partially Flatten a Sequence:
   Given a sequence of nested sequences, flatten to the leaf sequences which contain only non-sequential values.")


(def my-solution
  (fn [root]
    (filter
      #(and
        (sequential? %)
        (every? (complement sequential?) %))
      (tree-seq sequential? identity root)))
)


(def solutions [my-solution])
