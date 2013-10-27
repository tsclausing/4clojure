(ns com.fourclojure.problem.95
  "To Tree, or not to Tree:
   Given a root [value left-node right-node], determine whether or not the tree is a binary tree.")


(def my-solution
  (fn [root]
    (every?
      #(or
        (nil? %)
        (and (sequential? %) (= 3 (count %))))
      (tree-seq sequential? rest root)))
)


(def solutions [my-solution])
