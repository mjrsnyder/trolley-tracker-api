(ns trolly-api.database.connection)
			  
			  ;; "postgresql://localhost:5432/trolly_tracker"
			  ;; "postgresql://api_plus:JB1n78W9GTsuu9y@localhost:5432/trolly_tracker"
(def spec (or (System/getenv "DATABASE_URL")
              "postgresql://api_plus:JB1n78W9GTsuu9y@localhost:5432/trolly_tracker"))