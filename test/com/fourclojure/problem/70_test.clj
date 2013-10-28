(ns com.fourclojure.problem.70_test
  (:require [clojure.test :refer [deftest testing is]]
            [com.fourclojure.problem.70 :refer [solutions]]))


(deftest solution-70
  (testing "Word Sorting"
    (let [test-values [
         ; [sorted-words sentence]
           [["a" "day" "Have" "nice"], "Have a nice day."]
           [["a" "Clojure" "fun" "is" "language"], "Clojure is a fun language!"]
           [["fall" "follies" "foolish" "Fools" "for"], "Fools fall for foolish follies."]
         ]]
      (doseq [solution solutions
              [sorted-words sentence] test-values]
        (is (= (solution sentence) sorted-words))))))
