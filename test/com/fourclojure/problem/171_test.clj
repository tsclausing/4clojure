(ns com.fourclojure.problem.171-test
  (:require [clojure.test :refer [deftest, testing, is]]
            [com.fourclojure.problem.171 :refer [solutions]]))


(deftest solution-171
  (testing "Intervals"
    (let [test-values [
         ; [intervals sequence-of-integers]
           [[[1 3]], [1 2 3]]
           [[[1 3] [8 10]], [10 9 8 1 2 3]]
           [[[1 1]], [1 1 1 1 1 1 1]]
           [[], []]
           [[[1 4] [6 6] [9 11] [13 17] [19 19]], [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11]]
         ]]
      (doseq [solution solutions
              [intervals sequence-of-integers] test-values]
        (is (= (solution sequence-of-integers) intervals))))))
