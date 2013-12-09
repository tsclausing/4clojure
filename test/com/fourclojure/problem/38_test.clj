(ns com.fourclojure.problem.38-test
  (:require [clojure.test :refer [deftest testing is]]
            [com.fourclojure.problem.38 :refer [solutions]]))


(deftest solution-38
  (testing "Maximum value"
    (let [test-values [
         ; [max-value values]
           [8 [1 8 3 4]]
           [30 [30 20]]
           [67 [45 67 11]]
         ]]
      (doseq [solution solutions
              [max-value values] test-values]
        (is (= (apply solution values) max-value))))))
