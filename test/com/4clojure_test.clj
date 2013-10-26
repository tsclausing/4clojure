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


(deftest solution-153
  (testing "Pairwise Disjoint Sets"
    (let [test-values [
         ; [is-disjoint set-of-sets]
           [true  #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}}]
           [false #{#{:a :b :c :d :e}
                    #{:a :b :c :d}
                    #{:a :b :c}
                    #{:a :b}
                    #{:a}}]
           [true  #{#{[1 2 3] [4 5]}
                    #{[1 2] [3 4 5]}
                    #{[1] [2] 3 4 5}
                    #{1 2 [3 4] [5]}}]
           [true  #{#{'a 'b}
                    #{'c 'd 'e}
                    #{'f 'g 'h 'i}
                    #{''a ''c ''f}}]
           [false #{#{'(:x :y :z) '(:x :y) '(:z) '()}
                    #{#{:x :y :z} #{:x :y} #{:z} #{}}
                    #{'[:x :y :z] [:x :y] [:z] [] {}}}]
           [false #{#{(= "true") false}
                    #{:yes :no}
                    #{(class 1) 0}
                    #{(symbol "true") 'false}
                    #{(keyword "yes") ::no}
                    #{(class '1) (int \0)}}]
           [true  #{#{distinct?}
                    #{#(-> %) #(-> %)}
                    #{#(-> %) #(-> %) #(-> %)}
                    #{#(-> %) #(-> %) #(-> %)}}]
           [false #{#{(#(-> *)) + (quote mapcat) #_ nil}
                    #{'+ '* mapcat (comment mapcat)}
                    #{(do) set contains? nil?}
                    #{, , , #_, , empty?}}]
         ]]
      (doseq [[is-disjoint set-of-sets] test-values]
        (is (= (com.4clojure/solution-153 set-of-sets) is-disjoint))))))
