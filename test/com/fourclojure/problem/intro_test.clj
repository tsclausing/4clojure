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


(deftest maps-10
  (is (= 20
         ((hash-map :a 10, :b 20, :c 30) :b)
         (:b {:a 10, :b 20, :c 30}))))


(deftest sequences-12
  (is (= 3
         (first '(3 2 1))
         (second [2 3 4])
         (last (list 1 2 3)))))


(deftest functions-14
  (is (= 8
         ((fn add-five [x] (+ x 5)) 3)
         ((fn [x] (+ x 5)) 3)
         (#(+ % 5) 3)
         ((partial + 5) 3))))


(deftest reduce-64
  (is (= 15 (reduce + [1 2 3 4 5])))
  (is (=  0 (reduce + [])))
  (is (=  6 (reduce + 1 [2 3]))))


(deftest some-48
  (is (= 6
         (some #{2 7 6} [5 6 7 8])
         (some #(when (even? %) %) [5 6 7 8]))))


(deftest iterate-45
  (is (= [1 4 7 10 13]
         (take 5 (iterate #(+ 3 %) 1)))))


(deftest destructuring-52
  (is (= [2 4]
         (let [[a b c d e f g] (range)]
           [c e]))))


(deftest destructuring-173
  (is (= 3
         (let [[function a] [+ (range 3)]]
           (apply function a))
         (let [[[function a] b] [[+ 1] 2]]
           (function a b))
         (let [[function a] [inc 2]]
           (function a)))))


(deftest trampoline-76
  (is (= [1 3 5 7 9 11]
         (letfn
             [(foo [x y] #(bar (conj x y) y))
              (bar [x y] (if (> (last x) 10)
                           x
                           #(foo x (+ 2 y))))]
           (trampoline foo [] 1)))))
