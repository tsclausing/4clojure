(ns com.fourclojure.problem.130-test
  (:require [clojure.test :refer [deftest testing is]]
            [com.fourclojure.problem.130 :refer [solutions]]))


(deftest solution-130
  (testing "Tree Reparenting"
    (let [test-values [
         ; [[new-parent tree] new-tree]
           [['n '(n)] '(n)]
           [['a '(t (e) (a))] '(a (t (e)))]
           [['e '(a (t (e)))] '(e (t (a)))]
           [['a '(c (b (a)))] '(a (b (c)))]
           [['d
             '(a (b (c) (d) (e)) (f (g) (h)))]
            '(d (b (c) (e) (a (f (g) (h)))))]
           [['c
             '(a (b (c (d) (e)) (f (g) (h))) (i (j (k) (l)) (m (n) (o))))]
            '(c (d) (e) (b (f (g) (h)) (a (i (j (k) (l)) (m (n) (o))))))]
         ]]
      (doseq [solution solutions
              [[new-parent tree] new-tree] test-values]
        (is (= (solution new-parent tree) new-tree))))))
