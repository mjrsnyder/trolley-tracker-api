# trolley-tracker-api

###Currently deployed on Digital Ocean 

###http://104.131.44.166/

###Clojure / Postgres / Nginx

#Authentication
##Roles

### Admin
 - Adds account (POST /api/v1/account)
 - Updates account (POST /api/v1/account/:id)
 - Reads account (GET /api/v1/account/:id)

### Vehicle
 - Adds location (POST /api/v1/trolly/:id/location)

### App
 - Reads location (GET /api/v1/trolly/:id/location)

### Test Credentials (basic auth)
 - brigade / brigade

##Find The Fake Trolly:
curl -u brigade:brigade http://104.131.44.166/api/v1/trolly/1/location

