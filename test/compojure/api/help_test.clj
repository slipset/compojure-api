(ns compojure.api.help-test
  (:require [compojure.api.help :as help]
            [compojure.api.meta :as meta]
            [midje.sweet :refer :all]))

(facts "help-for-api-meta"
  (fact "all restructure-param methods have a help text"
    (let [restructure-method-names (-> meta/restructure-param methods keys)
          meta-help-topics (-> (methods help/help-for)
                               (dissoc ::help/default)
                               keys
                               (->> (filter #(= :meta (first %)))
                                    (map second)))]
      (set restructure-method-names) => (set meta-help-topics))))
