(ns com.fourclojure.problem.166-test
  (:require [clojure.test :refer [deftest testing is]]
            [com.fourclojure.problem.166 :refer [solutions]]))


(deftest solution-166
  (testing "Comparisons"
    (let [test-values [
         ; [output input]
           [:gt, [< 5 1]]
           [:eq, [(fn [x y] (< (count x) (count y))) "pear" "plum"]]
           [:lt, [(fn [x y] (< (mod x 5) (mod y 5))) 21 3]]
           [:gt [> 0 2]]
         ]]
      (doseq [solution solutions
              [output input] test-values]
        (is (= (apply solution input) output))))))
