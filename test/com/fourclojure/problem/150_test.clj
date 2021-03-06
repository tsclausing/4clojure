(ns com.fourclojure.problem.150-test
  (:require [clojure.test :refer [deftest testing is]]
            [com.fourclojure.problem.150 :as p150]))


;; test parts

(deftest int-to-seq
  (testing "integer to sequence of digits"
    (is (= '(1 2 3) (p150/int->seq 123)))
    (is (= '(1 0 0) (p150/int->seq 100)))
    (is (= '(0) (p150/int->seq 0)))))

(deftest seq-to-int
  (testing "sequence of digits to integer"
    (is (= (p150/seq->int '(1 2 3)) 123))
    (is (= (p150/seq->int '(1 0 0)) 100))
    (is (= (p150/seq->int '(0)) 0))))

(deftest pal
  (testing "create a palindrome from the left half"
    (is (= (p150/pal 1 true)
           (p150/palstr 1 true)
           1))
    (is (= (p150/pal 1)
           (p150/palstr 1)
           11))
    (is (= (p150/pal 12345 true)
           (p150/palstr 12345 true)
           123454321))
    (is (= (p150/pal 12345 false)
           (p150/palstr 12345 false)
           1234554321))))


;; test solutions

(deftest solution-150
  (testing "Palindromic Numbers"
    (doseq [solution p150/solutions] (time (do
      (println solution)

      (is (= (take 26 (solution 0))
             [0 1 2 3 4 5 6 7 8 9
              11 22 33 44 55 66 77 88 99
              101 111 121 131 141 151 161]))

      (is (= (take 16 (solution 162))
             [171 181 191 202
              212 222 232 242
              252 262 272 282
              292 303 313 323]))

      (is (= (take 6 (solution 1234550000))
             [1234554321 1234664321 1234774321
              1234884321 1234994321 1235005321]))

      (is (= (first (solution (* 111111111 111111111)))
             (* 111111111 111111111)))

      (is (= (set (take 199 (solution 0)))
             (set (map #(first (solution %)) (range 0 10000)))))

      (is (= true
             (apply < (take 6666 (solution 9999999)))))

      (is (= (nth (solution 0) 10101)
             9102019)))))))
