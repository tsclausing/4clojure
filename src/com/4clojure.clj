(ns com.4clojure
  "Solutions to problems found at http://www.4clojure.com/problems")


(def solution-95
  (fn binary-tree? [root]
    "Given a root [value left-node right-node], determine whether or not the tree is a binary tree.
     http://www.4clojure.com/problem/95"
    (every?
      #(or
        (nil? %)
        (and (sequential? %) (= 3 (count %))))
      (tree-seq sequential? rest root)))
)
