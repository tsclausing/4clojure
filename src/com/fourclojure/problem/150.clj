(ns com.fourclojure.problem.150
  "Palindromic Numbers")


(def my-solution
  (fn [start]
    (letfn [(palindrome? [number]
                         (let [str-num (str number)]
                           (= str-num (clojure.string/reverse str-num))))]
      (filter palindrome? (iterate inc start))))
)


(def my-solution2

  (fn [start]
    (let [str-start (str start)
          start-a? (-> str-start count odd?)
          ;_ (println :start-a? start-a?)
          start-stage-pow (dec (Math/ceil (/ (count str-start) 2)))
          ;_ (println :start-stage-pow start-stage-pow)
          start-stage (Math/pow 10 start-stage-pow)
          ;_ (println :start-stage start-stage)
          str-start-left (clojure.string/join (take (inc start-stage-pow) str-start))
          ;_ (println :str-start-left str-start-left)
          start-stage-end (* 10 start-stage)
          ;_ (println :start-stage-end start-stage-end)
          start-left (inc (Long/parseLong str-start-left))
          ;_ (println :start-left start-left)
          start-palindrome (if start-a?
                           (str str-start-left (clojure.string/join (reverse (butlast str-start-left))))
                           (str str-start-left (clojure.string/join (reverse str-start-left))))
          ;_ (println :start-palindrome start-palindrome)
          ]

      (filter #(>= % start)
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
                                              (str str-left (clojure.string/join (reverse str-left))))

                             ret-val [new-palindrome
                                      new-a?
                                      new-stage
                                      (* 10 new-stage)
                                      new-left]
                             ]
                         ret-val

                         ))
                     ; initial values
                     [start-palindrome
                      start-a?
                      (int start-stage) (int start-stage-end),
                      start-left]
                     )))))

)


(defn n-count [a]
  "or with interop ... (inc (Math/floor (Math/log10 a)))"
  (count (take-while pos? (iterate (partial #(quot % 10)) a))))

(defn n-conj [a b]
  (+ b (*
         (apply * (repeat (n-count b) 10))
         a)))

(defn n-reverse [a]
  (reduce #(+ (* 10 %1) (first %2))
          0
          (take (inc (n-count a)) (iterate
                                    (fn [[digit number]] [(rem number 10) (quot number 10)])
                                    [0 a]))))

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


;; Solutions to test

(def solutions [my-solution4])
