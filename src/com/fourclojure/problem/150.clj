(ns com.fourclojure.problem.150
  "Palindromic Numbers")


;; Solution 1 - Naive solution for very small palindromes. Excluded from tests due to poor performance.

(def my-solution
  (fn [start]
    (letfn [(palindrome? [number]
                         (let [str-num (str number)]
                           (= str-num (clojure.string/reverse str-num))))]
      (filter palindrome? (iterate inc start))))
)


;; Solution 2 - Performant version of Solution 1

(def my-solution2
  (fn [start]
    (let [str-start (str start)
          start-a? (-> str-start count odd?)
          start-stage-pow (dec (Math/ceil (/ (count str-start) 2)))
          start-stage (Math/pow 10 start-stage-pow)
          str-start-left (clojure.string/join (take (inc start-stage-pow) str-start))
          start-stage-end (* 10 start-stage)
          start-left (inc (Long/parseLong str-start-left))
          start-palindrome (if start-a?
                           (str str-start-left (clojure.string/join (reverse (butlast str-start-left))))
                           (str str-start-left (clojure.string/join (reverse str-start-left))))]

      (drop-while #(< % start)
              (map #(Long/parseLong (first %))
                   (iterate
                     (fn [[palindrome, a? stage stage-end left]]
                       (let [stage-end? (= (inc left) stage-end)
                             new-a? (if stage-end? (not a?) a?)
                             new-stage (if (and
                                             (not a?)
                                             stage-end?) (* 10 stage) stage)
                             new-left (if stage-end? new-stage (inc left))
                             str-left (str left)
                             new-palindrome (if a?
                                              (str str-left (clojure.string/join (reverse (butlast str-left))))
                                              (str str-left (clojure.string/join (reverse str-left))))]
                         [new-palindrome
                          new-a?
                          new-stage
                          (* 10 new-stage)
                          new-left]))

                     ; initial values
                     [start-palindrome
                      start-a?
                      (int start-stage) (int start-stage-end),
                      start-left])))))
)


;; Solution 3 - Incomplete. No strings or Java interop.

(defn n-count [n]
  "or with interop ... (inc (Math/floor (Math/log10 a)))"
  (count (take-while pos? (iterate (partial #(quot % 10)) n))))

(defn n-conj [a b]
  (+ b (*
         (apply * (repeat (n-count b) 10))
         a)))

(defn n-reverse [n]
  (reduce #(+ (* 10 %1) (first %2))
          0
          (take (inc (n-count n)) (iterate
                                    (fn [[digit number]] [(rem number 10) (quot number 10)])
                                    [0 n]))))

(defn n-take [i n]
  (nth (reverse (take-while pos? (iterate (partial #(quot % 10)) n))) (dec i)))

(defn n-start [n]
  )

(defn palindrome [left compact?]
  "For some number `a`, return its full or compact palindrome.
   e.g.: 123 becomes 123321, or compact becomes 12321"
  (let [right (if compact? (quot left 10) left)]
    (n-conj left (n-reverse right))))


(def my-solution3
  "Solution with no number<->string conversions and no Java interop."
)


;; Solution 4 - No number<->string conversion. Treats numbers as sequences of digits.

(def my-solution4
  (fn [start]
    (letfn [(digits [n]
                    (let [len (inc (Math/floor (Math/log10 n)))
                          lazy-digits (map (fn [i]
                                             (int (rem (Math/floor (/ n (Math/pow 10 (- len i)))) 10)))
                                           (range 1 (inc len)))]
                      (if (first lazy-digits)
                        lazy-digits
                        '(0))))

            (inc-digits [d]
                        (loop [d d ; digits
                               r 1 ; remainder
                               o '()] ; output
                          (cond
                            (not (pos? r)) ; no remainder? done
                              (concat d o)
                            (or (pos? r) (seq d)) ; remainder or more digits? continue
                              (let [sum (+ (or (last d) 0) r)
                                    [d2 r2] (if (> sum 9)
                                              [(rem sum 10) (quot sum 10)]
                                              [nil nil])]
                                (recur
                                  (butlast d)
                                  (or r2 0)
                                  (conj o (or d2 sum)))))))

            (palindrome-digits [d odd?]
                               (let [d-right (if odd? (-> d butlast reverse) (reverse d))]
                                 (concat d d-right)))

            (from-digits [d]
                         (reduce #(+ (* 10 %) %2) 0 d))]

      ; get starting digits from start integer
      (let [s-digits (digits start)
            s-count (count s-digits)
            s-odd? (odd? s-count)
            s-left (take (/ s-count 2) s-digits)]

        ; lazy sequence
        (drop-while #(< % start)
                (map (comp from-digits first)
                     (iterate (fn [[palindrome, left odd? pow]]
                                (let [end? (every? #{9} left)
                                      n-left (if (and end? odd?) ; reset at the end of an odd run, else increment
                                               (digits (Math/pow 10 pow))
                                               (inc-digits left))
                                      n-odd (if end? (not odd?) odd?) ; toggle odd at the end of every run
                                      n-pow (if (and end? (not odd?)) (inc pow) pow)] ; increment pow at end of an even run

                                  ; next values
                                  [(palindrome-digits n-left n-odd)
                                   n-left
                                   n-odd
                                   n-pow]))

                              ; starting values
                              [(palindrome-digits s-left s-odd?)
                               s-left
                               s-odd?
                               (dec (count s-left))])))))))


;; Solution 5 - No mirror/palindrome function. Join left and right lazy sequences.

(defn my-solution5 [start]
  "Infinite palindromes"
  (letfn [(left [] (mapcat #(repeat 2
                                    (range (Math/pow 10 %) (Math/pow 10 (inc %))))
                           (range)))]
    (drop-while #(< % start)
                (concat '(0)
                        (mapcat #(map (fn [d]
                                        (let [left (str (int d))
                                              right (clojure.string/join (reverse (take ((if (odd? %) identity dec) (count left)) left)))]
                                          (Long/parseLong (str left right))))
                                      %2)
                                (range)
                                (left))))))


;; Solutions to test

(def solutions [my-solution2
                my-solution4])
