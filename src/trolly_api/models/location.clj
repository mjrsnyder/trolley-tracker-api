(ns trolly-api.models.location
	(:require [clj-postgresql.core :as pg]
			  [clojure.java.jdbc :as sql]
			  [trolly-api.database.connection :as conn]))

(defn ^:private deconstruct-point [point]
	(def match (re-seq #"-?\d*\.\d*" point))
	{:lon (bigdec (first match)) :lat (bigdec (last match))})


(defn latest [for-trolly-id]
	(update-in 
		(first (sql/query conn/spec ["select * from locations_getlatestby_who(?::integer)" for-trolly-id ]))
		[:where] deconstruct-point))		

(defn create [who lat lon]
	(sql/query conn/spec ["SELECT locations_insert AS createdon FROM locations_insert(?::integer, ?::float, ?::float)" who lat lon]))