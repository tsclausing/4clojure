(ns com.fourclojure.problem.153-test
  (:require [clojure.test :refer [deftest, testing, is]]
            [com.fourclojure.problem.153 :refer [solutions]]))


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
      (doseq [solution solutions
              [is-disjoint set-of-sets] test-values]
        (is (= (solution set-of-sets) is-disjoint))))))

