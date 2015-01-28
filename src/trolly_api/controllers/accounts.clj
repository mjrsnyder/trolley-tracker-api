(ns trolly-api.controllers.accounts
	(:require [compojure.core :refer [defroutes GET POST context]]
			  [cemerick.friend :as friend]
              [ring.util.response :refer [response]]
              [trolly-api.models.account :as model]))

(defroutes routes
  (context "/accounts/:account-id" [account-id]
    (GET "/" request
   		(friend/authorize #{"admin"})
  		(response (model/get-by-id account-id)))
    (POST "/" {body :body} 
    	(friend/authorize #{"admin"} )
    	(println body)
    	(response (model/update account-id (get body "account-name") (get body "roles")))))
  (GET "/accounts" []
  		(friend/authorize #{"admin"})
  		(response (model/get-all)))
  (POST "/accounts" {body :body} 
    	(friend/authorize #{"admin"} )
    	(response (model/create (get body "account-name") (get body "password")  (get body "roles") )))

)