;; http://iloveponies.github.io/120-hour-epic-sax-marathon/one-function-to-rule-them-all.html
(ns one-function-to-rule-themall)

(defn concat-elements [a-seq]
  (if (empty? a-seq)
    '()
    (reduce concat a-seq)))

(defn str-cat [a-seq]
  (if (empty? a-seq)
    ""
    (reduce str (interpose " " a-seq))))

(defn my-interpose [x a-seq]
  (if (empty? a-seq)
    '()
    (rest (reduce #(conj %1 x %2) [] a-seq))))

(defn my-count [a-seq]
  (let [count (fn [count e]
                (inc count))]
    (reduce count 0 a-seq)))

(defn my-reverse [a-seq]
  (reduce conj '() a-seq))

(defn min-max-element [a-seq]
  (let [[f & s] a-seq]
    (cond
     (not f) []
     (not s) [f f]
     :else (let [minmax (fn [acc e]
                          [(min (first acc) e) (max (second acc) e)])]
             (reduce minmax [(first a-seq) (second a-seq)] a-seq)))))

(defn insert [sorted-seq n]
  (if (empty? sorted-seq)
    (cons n sorted-seq)
    (let [[x & xs] sorted-seq]
      (cond
       (< n x) (cons n sorted-seq)
       :else (cons x (insert xs n))))))

(defn insertion-sort [a-seq]
  (reduce insert [] a-seq))

(defn toggle [a-set elem]
  (if (contains? a-set elem)
    (disj a-set elem)
    (conj a-set elem)))

(defn parity [a-seq]
  (let [odd-accum (fn [accum e]
                    (toggle accum e))]
    (reduce odd-accum #{} a-seq)))

(defn minus
  ([x] (- x))
  ([x y] (- x y)))

(defn count-params [& more]
  (count more))

(defn my-*
  ([] 1)
  ([x] x)
  ([x y] (* x y))
  ([x y & more]
   (reduce * (* x y) more)))

(defn pred-and 
  ([] (fn [p] true))
  ([x] x)
  ([x y] (fn [p] (and (x p) (y p))))
  ([x y & more] (reduce pred-and (pred-and x y) more)))

(defn my-map [f a-seq]
  )
