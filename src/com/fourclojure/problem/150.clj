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


(def solutions [my-solution2])
