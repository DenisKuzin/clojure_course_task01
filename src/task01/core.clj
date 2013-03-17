(ns task01.core
  (:require [pl.danieljanus.tagsoup :refer :all])
  (:gen-class))


(defn get-li [data]
  (filter (fn [tag] (= (tag 0) :li)) (((((((((((data 5) 4) 3) 2) 9) 2) 4) 5) 3) 3) 2)))

(defn get-h3 [li]
  (filter (fn [tag] (= (tag 0) :h3)) (li 2)))

(defn get-href [h3]
  ((((first h3) 2) 1) :href))

(defn get-links []
" 1) Find all elements containing {:class \"r\"}.

Example:
[:h3 {:class \"r\"} [:a {:shape \"rect\", :class \"l\",
                         :href \"https://github.com/clojure/clojure\",
                         :onmousedown \"return rwt(this,'','','','4','AFQjCNFlSngH8Q4cB8TMqb710dD6ZkDSJg','','0CFYQFjAD','','',event)\"}
                     [:em {} \"clojure\"] \"/\" [:em {} \"clojure\"] \" · GitHub\"]]

   2) Extract href from the element :a.

The link from the example above is 'https://github.com/clojure/clojure'.

  3) Return vector of all 10 links.

Example: ['https://github.com/clojure/clojure', 'http://clojure.com/', . . .]
"
  (let [data (parse "clojure_google.html") li-seq (get-li data) h3-seq (map get-h3 li-seq)]
    (vec (map get-href h3-seq))))

(defn -main []
  (println (str "Found " (count (get-links)) " links!")))


