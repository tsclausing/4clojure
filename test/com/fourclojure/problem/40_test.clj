(ns com.fourclojure.problem.40-test
  (:require [clojure.test :refer [deftest testing is]]
            [com.fourclojure.problem.40 :refer [solutions]]))


(deftest solution-40
  (testing "Interpose a Seq"
    (let [test-values [
         ; [output input]
           [[1 0 2 0 3], [0 [1 2 3]]]
           [[:a :z :b :z :c :z :d], [:z [:a :b :c :d]]]
         ]]
      (doseq [solution solutions
              [output [separator items]] test-values]
        (is (= output (solution separator items)))
        (is (= "one, two, three"
               (apply str (solution ", " ["one" "two" "three"]))))))))
