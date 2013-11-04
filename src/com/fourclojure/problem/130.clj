(ns com.fourclojure.problem.130
  "Tree Reparenting:
   Given a node to make the root of a tree, and the tree to re-parent, write a function which re-parents the tree with
   the new root while maintaining all existing connections between nodes.")


(def my-solution
  (fn [new-root tree]
    (reduce
      ; handle the actual re-parenting
      #(concat %2 (list (filter (complement #{%2}) %1)))

      ; determine nodes to re-parent
      (loop [nodes-to-reparent '()
             remaining-nodes (filter seq? (reverse (tree-seq seq? identity tree)))]

        (let [node (first remaining-nodes)
              reparent (or
                         (when (= (first node) new-root) node)
                         (when (some #{(first nodes-to-reparent)} node) node))
              nodes-to-reparent (if reparent
                                  (conj nodes-to-reparent reparent)
                                  nodes-to-reparent)
              remaining-nodes (rest remaining-nodes)]

          (if (seq remaining-nodes)
            (recur
              nodes-to-reparent
              remaining-nodes)
            nodes-to-reparent)))))
)


(def solutions [my-solution])
