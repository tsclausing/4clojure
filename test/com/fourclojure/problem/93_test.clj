(ns com.fourclojure.problem.93-test
  (:require [clojure.test :refer [deftest testing is]]
            [com.fourclojure.problem.93 :refer [solutions]]))


(deftest solution-93
  (testing "Partially Flatten a Sequence"
    (let [test-values [
          ;[flattened original]
           [[["Do"] ["Nothing"]], [["Do"] ["Nothing"]]]
           [[[:a :b] [:c :d] [:e :f]], [[[[:a :b]]] [[:c :d]] [:e :f]]]
           ['((1 2)(3 4)(5 6)), '((1 2)((3 4)((((5 6))))))]
         ]]
      (doseq [solution solutions
              [flattened original] test-values]
        (is (= (solution original) flattened))))))
