# trolley-tracker-api

Currently deployed on Digital Ocean 

Clojure / Postgres / Nginx

#Interaction
##GET

http://104.131.44.166/api/trolly/1/location

##POST

curl -X POST -H "Content-Type:application/json" -H "Cache-Control:no-cache" -H "Postman-Token:a963db09-aca3-dbd5-8ed7-fdc21c5595f6" -d '{"lon":"-82.4046505", "lat":"34.844403"}' http://104.131.44.166:3000/api/trolly/1/location
