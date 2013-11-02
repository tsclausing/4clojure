(ns com.fourclojure.problem.intro_test
  "Tests for introductory problems"
  (:require [clojure.test :refer [deftest is]]))


(deftest strings-3
  (is (= "HELLO WORLD") (.toUpperCase "hello world")))


(deftest lists-4
  (is (= (list :a :b :c) '(:a :b :c))))


(deftest vectors-6
  (is (= [:a :b :c]
         (list :a :b :c)
         (vec '(:a :b :c))
         (vector :a :b :c))))


(deftest sets-8
  (is (= #{:a :b :c :d}
         (set '(:a :a :b :c :c :c :c :d :d))
         (clojure.set/union #{:a :b :c} #{:b :c :d}))))
