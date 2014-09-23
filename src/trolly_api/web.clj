(ns trolly-api.web
  (:use 	ring.middleware.json)
  (:require [compojure.core :refer [defroutes GET context]]
            [ring.adapter.jetty :as ring] 
            [ring.util.response :refer [response]]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [trolly-api.controllers.locations :as locations])
  
  (:gen-class))

(defroutes app-routes
 	(GET "/" [] "<h2>Hello World</h2>")
  	(context "/api" []
		locations/routes)
  	(route/not-found 
    	(response {:message "Page not found"})))

(def app
	(-> app-routes
		wrap-json-response
		wrap-json-body))

;;;(def app
;;;  (-> (handler/api app-routes))


;;;(defn -main []
;;;  (ring/run-jetty #'routes {:port 8080 :join? false}))
