(ns com.fourclojure.problem.121-test
  (:require [clojure.test :refer [deftest testing is]]
            [com.fourclojure.problem.121 :refer [solutions]]))


(deftest solution-121
  (testing "Universal Computation Engine"
    (let [test-values [
         ; [result formula values]
           [2 '(/ a b) '{b 8 a 16}]
           [8 '(+ a b 2) '{a 2 b 4}]
           [7 '(+ [- a 1] b 2) '{a 2 b 4}]
           [1 '(/ (+ x 2) (* 3 (+ y 1))) '{x 4 y 1}]
         ]]
       (doseq [solution solutions
               [result formula values] test-values]
         (is (= result ((solution formula) values)))
         (is (= [6 0 -4]
                (map
                  (solution '(* (+ 2 a) (- 10 b)))
                  '[{a 1 b 8}
                    {b 5 a -2}
                    {a 2 b 11}])))))))
