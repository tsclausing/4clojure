(ns com.fourclojure.problem.44
  "Rotate a Sequence")


(def my-solution
  (fn [from items]
    (let [[a b] (split-at (mod from (count items)) items)]
      (concat b a))))


(def Ox89-solution
  #(let [n (mod % (count %2))]
           (concat (drop n %2)
                   (take n %2))))


(def solutions [my-solution
                Ox89-solution])
