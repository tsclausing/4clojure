(ns com.fourclojure.problem.34-test
  (:require [clojure.test :refer [deftest testing is]]
            [com.fourclojure.problem.34 :refer [solutions]]))


(deftest solution-34
  (testing "Implement range"
    (let [test-values [
         ; [[start end] sequence]
           [[1 4] '(1 2 3)]
           [[-2 2] '(-2 -1 0 1)]
           [[5 8] '(5 6 7)]
         ]]
      (doseq [solution solutions
              [[start end] sequence] test-values]
        (is (= (solution start end) sequence))))))
