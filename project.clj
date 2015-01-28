(defproject trolly-api "0.0.1"
  :description "API for interacting with Greenville trolly data"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :main "trolly-api.web"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler trolly-api.web/app
         :nrepl {:start? true
                 :port 9998}}
                 :profiles
  {:uberjar {:aot :all}
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}},
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.2.2"]],
    :env {:dev true}}}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/java.jdbc "0.3.2"]
                 [postgresql "9.1-901.jdbc4"]
                 [ring/ring-jetty-adapter "1.3.1"]
                 [ring/ring-json "0.3.1"]
                 [compojure "1.1.9"]
                 [com.cemerick/friend "0.2.1"]
                 [clj-postgresql "0.3.0-20140917.124920-3"]])
