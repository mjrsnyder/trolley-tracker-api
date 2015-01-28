(ns trolly-api.controllers.locations
	(:require [compojure.core :refer [defroutes GET POST context]]
			  [cemerick.friend :as friend]
              [ring.util.response :refer [response]]
              [trolly-api.models.location :as model]))

(defroutes routes
  (context "/trolly/:trolly-id" [trolly-id]
    (GET "/location" request
   		(friend/authorize #{"app"} )
   		(response (model/latest trolly-id)))
    (POST "/location" {body :body} 
    	(friend/authorize #{"vehicle"} )
    	(println body)
    	(println (get body "lat"))
    	(println (get body "lon"))
    	(response (model/create trolly-id (get body "lat") (get body "lon"))))
  )
)