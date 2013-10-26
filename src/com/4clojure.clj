(ns com.4clojure
  " 4clojure.com problem solutions.

  The complete list of problems may be found at http://www.4clojure.com/problems
  or http://www.4clojure.com/problem/{number} for individual problems.")


(def solution-93
  (fn [root]
    "Given a nested sequence, flatten to the leaves which contain only non-sequential values."
    (filter
      #(and
        (sequential? %)
        (every? (complement sequential?) %))
      (tree-seq sequential? identity root)))
)


(def solution-95
  (fn [root]
    "Given a root [value left-node right-node], determine whether or not the tree is a binary tree."
    (every?
      #(or
        (nil? %)
        (and (sequential? %) (= 3 (count %))))
      (tree-seq sequential? rest root)))
)
