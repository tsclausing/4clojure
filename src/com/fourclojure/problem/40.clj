(ns com.fourclojure.problem.40
  "Interpose a Seq")


(def my-solution
  #(drop-last (interleave %2 (repeat %))))


(def kohyama
  #(rest (interleave (repeat %) %2)))


(def solutions [my-solution
                kohyama])
