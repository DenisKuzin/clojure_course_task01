(ns task01.core
  (:require [pl.danieljanus.tagsoup :refer :all])
  (:gen-class))


(defn get-h3 [li]
  (doall
   (filter (fn [tag] (= (tag 0) :h3)) (li 2))))

(defn get-href [h3]
  ((((first h3) 2) 1) :href))

(defn get-links []
  (let [data (parse "clojure_google.html")
        li-seq (doall
                (filter (fn [tag] (= (tag 0) :li)) (((((((((((data 5) 4) 3) 2) 9) 2) 4) 5) 3) 3) 2)))
        h3-seq (doall
                (map get-h3 li-seq))
        links-seq (doall
                   (map get-href h3-seq))]
    (vec links-seq)))

(defn -main []
  (println (str "Found " (count (get-links)) " links!")))


