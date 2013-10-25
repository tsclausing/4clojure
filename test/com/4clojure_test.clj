(ns com.4clojure-test
  (:require [clojure.test :refer [deftest testing is]]
            [com.4clojure]))


(deftest solution-95
  (testing "To Tree, or not to Tree"
    (let [test-trees [
         ; [is-binary tree]
           [true  '(:a (:b nil nil) nil)]
           [false '(:a (:b nil nil))]
           [true  [1 nil [2 [3 nil nil] [4 nil nil]]]]
           [false [1 [2 nil nil] [3 nil nil] [4 nil nil]]]
           [true  [1 [2 [3 [4 nil nil] nil] nil] nil]]
           [false [1 [2 [3 [4 false nil] nil] nil] nil]]
           [false '(:a nil ())]
         ]]
      (doseq [[is-binary tree] test-trees]
        (is (= (com.4clojure/solution-95 tree) is-binary))))))
