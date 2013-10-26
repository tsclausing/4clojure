(ns com.4clojure-test
  (:require [clojure.test :refer [deftest testing is]]
            [com.4clojure]))


(deftest solution-93
  (testing "Partially Flatten a Sequence"
    (let [test-values [
         ; [flattened original]
           [[["Do"] ["Nothing"]], [["Do"] ["Nothing"]]]
           [[[:a :b] [:c :d] [:e :f]], [[[[:a :b]]] [[:c :d]] [:e :f]]]
           ['((1 2)(3 4)(5 6)), '((1 2)((3 4)((((5 6))))))]
         ]]
      (doseq [[flattened original] test-values]
        (is (= (com.4clojure/solution-93 original) flattened))))))


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
      (doseq [[is-binary tree] test-values]
        (is (= (com.4clojure/solution-95 tree) is-binary))))))
