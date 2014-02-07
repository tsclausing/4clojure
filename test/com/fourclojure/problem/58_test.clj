(ns com.fourclojure.problem.58-test
  (:require [clojure.test :refer [deftest testing is]]
            [com.fourclojure.problem.58 :refer [solutions]]))


(deftest solution-58
  (testing "Function Composition"
    (let [test-values [
         ; [output [funcs] [args]]
           [[3 2 1], [rest reverse]   [[1 2 3 4]]]
           [5, [(partial + 3) second] [[1 2 3 4]]]
           [true, [zero? #(mod % 8) +] [3 5 7 9]]
           ["HELLO", [#(.toUpperCase %) #(apply str %) take] [5 "hello world"]]
         ]]
      (doseq [solution solutions
              [output funcs args] test-values]
        (is (= (apply (apply solution funcs) args) output))))))
