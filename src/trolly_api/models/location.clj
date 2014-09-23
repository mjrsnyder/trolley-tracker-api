(ns trolly-api.models.location
	(:require [clj-postgresql.core :as pg]
			  [clojure.java.jdbc :as sql]))

(def spec (or (System/getenv "DATABASE_URL")
              "postgresql://localhost:5432/trolly_tracker"))

(defn ^:private deconstruct-point [point]
	(def match (re-seq #"\d*\.\d*" point))
	{:lon (first match) :lat (last match)})

(defn latest [for-trolly-id]
	(update-in 
		(first (sql/query spec ["select * from locations_getlatestby_who(?::integer)" for-trolly-id ]))
		[:where] deconstruct-point))		

(defn create [who lat lon]
	(sql/query spec ["SELECT locations_insert AS createdon FROM locations_insert(?::integer, ?::float, ?::float)" who lat lon]))