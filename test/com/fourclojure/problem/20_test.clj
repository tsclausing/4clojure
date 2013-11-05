(ns com.fourclojure.problem.20-test
  (:require [clojure.test :refer [deftest testing is]]
            [com.fourclojure.problem.20 :refer [solutions]]))


(deftest solution-20
  (testing "Penultimate Element"
    (let [test-values [
         ; [next-to-last sequence]
           [4 (list 1 2 3 4 5)]
           ["b" ["a" "b" "c"]]
           [[1 2] [[1 2] [3 4]]]
           [nil '(:a)]
           [nil ()]
         ]]
      (doseq [solution solutions
              [next-to-last sequence] test-values]
        (is (= (solution sequence) next-to-last))))))
