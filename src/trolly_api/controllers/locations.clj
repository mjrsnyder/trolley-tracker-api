(ns trolly-api.controllers.locations
	(:require [compojure.core :refer [defroutes GET POST context]]
              [ring.util.response :refer [response]]
              [trolly-api.views.locations :as view]
              [trolly-api.models.location :as model]))

(defroutes routes
  (context "/trolly/:trolly-id" [trolly-id]
    (GET "/location" [] 
    	(response (model/latest trolly-id)))
    (POST "/location" {body :body} 
    	(response (model/create trolly-id (get body "lat") (get body "lon"))))))