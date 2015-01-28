(ns trolly-api.models.account
	(:require [clj-postgresql.core :as pg]
			  [clojure.java.jdbc :as sql]
			  [trolly-api.database.connection :as conn]))

;;(def spec (or (System/getenv "DATABASE_URL")
 ;;             "postgresql://api_plus:JB1n78W9GTsuu9y@localhost:5432/trolly_tracker"))

(defn create [account-name password roles]
	(sql/query conn/spec ["SELECT * FROM accounts_insert(?::text, ?::varchar, ?::text[])" account-name password roles]))

(defn update [account-id account-name roles]
	(println account-id)
	(println account-name)
	(println roles)
	(first (sql/query conn/spec ["SELECT * FROM accounts_update(?::integer, ?::varchar, ?::text[])" account-id account-name roles])))

(defn get-by-id [account-id]
	(first (sql/query conn/spec ["SELECT * FROM accounts_getby_id(?::integer)" account-id ])))

(defn get-all []
	(sql/query conn/spec ["SELECT * FROM accounts_get()"]))

(defn get-by-name-password [account-name password]
	(first (sql/query conn/spec ["SELECT * FROM accounts_getby_name_password(?::text, ?::varchar)" account-name password ])))
