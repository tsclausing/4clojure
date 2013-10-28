(ns com.fourclojure.problem.171
  "Intervals:
   Write a function that takes a sequence of integers and returns a sequence of 'intervals'")


(def my-solution
  (fn [sequence-of-integers]
    (let [sorted-integers (sort sequence-of-integers)]
      (partition 2 (reduce
        (fn [output, i]
          (if (or
                (= (last output) i)
                (= (last output) (dec i)))
            (concat (take (dec (count output)) output)  [i])
            (concat output (repeat 2 i))))
        (if (seq sorted-integers) (repeat 2 (first sorted-integers)) [])
        sorted-integers))))
)


(def aceeca1
  (fn [x]
    (let [x (distinct (sort x))
          add (fn [[s t] x] (if (= 1 (- x t)) [s x] [x x]))]
      (map last (partition-by first (next (reductions add [0 (first x)] x))))))
)


(def solutions [my-solution
                aceeca1])
