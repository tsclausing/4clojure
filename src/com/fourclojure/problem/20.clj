(ns com.fourclojure.problem.20
  "Penultimate Element:
   Write a function which returns the second to last element from a sequence.")


(def solutions [#(second (reverse %))
                (comp second reverse)
                (comp last butlast)
               ])
