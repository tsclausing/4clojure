(ns com.fourclojure.problem.153
  "Pairwise Disjoint Sets:
   Given a set of sets, return true if the sets are pairwise (mutually) disjoint."
  (:require clojure.set))


(def my-solution
  (def solution-153
    (fn [set-of-sets]
      (let [count-all (reduce + (map count set-of-sets))
            count-unique (count (reduce clojure.set/union set-of-sets))]
        (= count-all count-unique)))
    )
)


(def aceeca1
  (fn [set-of-sets]
    "http://www.4clojure.com/user/aceeca1"
    (apply distinct? (apply concat set-of-sets)))
)


(def solutions [my-solution
                aceeca1])
