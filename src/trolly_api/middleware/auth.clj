(ns trolly-api.middleware.auth
  (:require 
            [trolly-api.models.account :as account]
            [cemerick.friend :as friend]
            (cemerick.friend [workflows :as workflows]
                             [credentials :as creds])))

(defn get_user_roles
  [creds_map]
  (println creds_map) 
  (def user (account/get-by-name-password (get creds_map :username) (get creds_map :password)))
  (println user)
  user)

(defn unauthenticated [v]
  {:status 401 :body "Unauthenticated"})

(defn friend-middleware   
  "Returns a middleware that enables authentication via Friend."
  [handler]
  (let [friend-m {:allow-anon? true
                  :redirect-on-auth? false
                  :credential-fn get_user_roles
                  :unauthenticated-handler unauthenticated
                  :workflows
                  ;; Note that ordering matters here. Basic first.
                  [(workflows/http-basic :realm "/")]
                 }]
    (-> handler
        (friend/authenticate friend-m))))