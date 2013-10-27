(ns com.fourclojure.problem.95-test
  (:require [clojure.test :refer [deftest testing is]]
            [com.fourclojure.problem.95 :refer [solutions]]))


(deftest solution-95
  (testing "To Tree, or not to Tree"
    (let [test-values [
         ; [is-binary tree]
           [true  '(:a (:b nil nil) nil)]
           [false '(:a (:b nil nil))]
           [true  [1 nil [2 [3 nil nil] [4 nil nil]]]]
           [false [1 [2 nil nil] [3 nil nil] [4 nil nil]]]
           [true  [1 [2 [3 [4 nil nil] nil] nil] nil]]
           [false [1 [2 [3 [4 false nil] nil] nil] nil]]
           [false '(:a nil ())]
         ]]
      (doseq [solution solutions
              [is-binary tree] test-values]
        (is (= (solution tree) is-binary))))))
