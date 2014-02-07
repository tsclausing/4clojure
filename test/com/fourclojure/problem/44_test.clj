(ns com.fourclojure.problem.44-test
  (:require [clojure.test :refer [deftest testing is]]
            [com.fourclojure.problem.44 :refer [solutions]]))


(deftest solution-44
  (testing "Rotate a Sequence"
    (let [test-values [
         ; [output input]
           ['(3 4 5 1 2), [2 [1 2 3 4 5]]]
           ['(4 5 1 2 3), [-2 [1 2 3 4 5]]]
           ['(2 3 4 5 1), [6 [1 2 3 4 5]]]
           ['(:b :c :a),  [1 '(:a :b :c)]]
           ['(:c :a :b),  [-4 '(:a :b :c)]]
         ]]
      (doseq [solution solutions
              [output [from items]] test-values]
        (is (= output (solution from items)))))))

