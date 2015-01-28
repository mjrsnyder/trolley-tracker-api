(ns trolly-api.web
  (:use 	ring.middleware.json)
  (:require [compojure.core :refer [defroutes GET context]]
            [ring.adapter.jetty :as ring] 
            [ring.util.response :refer [response, status]]
            [compojure.route :as route]
            [compojure.handler :refer [api]]
            [ring.middleware.json :as rj]
            [trolly-api.middleware.auth :as auth]
            [cemerick.friend :as friend]
            (cemerick.friend [workflows :as workflows]
                             [credentials :as creds])
            [trolly-api.controllers.locations :as locations]
            [trolly-api.controllers.accounts :as accounts])
  (:gen-class))

(defroutes site-routes
  (GET "/" [] "<h2>Hello World</h2>")
)

(defroutes app-routes
  (GET "/" [] "<h2>Hello Trolly Tracker API")
 	(context "/api/v1" [] locations/routes accounts/routes)
	(route/not-found  (response {:message "Page not found"}))
)

(def app
	(-> app-routes
    auth/friend-middleware
    rj/wrap-json-body
		rj/wrap-json-response
    (api))
  )

;;;(def app
;;;  (-> (handler/api app-routes))

(defn -main []
  (ring/run-jetty #'app {:port 3000 :join? false}))
