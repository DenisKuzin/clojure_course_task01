(ns task01.core
  (:require [pl.danieljanus.tagsoup :refer :all])
  (:gen-class))


(defn get-node-by-path
  "Get tree root and walk by indexes"
  [root & more]
  (doall
   (reduce (fn [node index] (node index)) root more)))

(defn filter-by-tag
  "Filter nodes sequence which has tag"
  [tag seq]
  (doall
   (filter (fn [node] (= (node 0) tag)) seq)))

(defn extract-h3
  "Extracts h3 tags from li's"
  [li-seq]
  (doall
   (map (fn [li] (filter-by-tag :h3 (li 2))) li-seq)))

(defn extract-href
  "Extracts href attribute from h3's"
  [h3-seq]
  (doall
   (map (fn [h3] ((((first h3) 2) 1) :href)) h3-seq)))

(defn get-links
  "Get links from google serp"
  []
  (let [data (parse "clojure_google.html")
        ol-tag (get-node-by-path data 5 4 3 2 9 2 4 5 3 3 2)
        li-seq (filter-by-tag :li ol-tag)
        h3-seq (extract-h3 li-seq)
        links-seq (extract-href h3-seq)
        links-vec (vec links-seq)]
    links-vec))

(defn -main []
  (println (str "Found " (count (get-links)) " links!")))


