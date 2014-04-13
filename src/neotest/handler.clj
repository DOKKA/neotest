

(ns neotest.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route])
  (:import (org.neo4j.graphdb
            DynamicLabel
            GraphDatabaseService
            Label
            Node
            ResourceIterator
            Transaction
            factory.GraphDatabaseFactory
            schema.IndexDefinition
            schema.Schema)))

(def db
  (let [path "C:\\Users\\kevin\\code\\neotest\\resources\\db1"]
    (. (new GraphDatabaseFactory) (newEmbeddedDatabase path))))

(defroutes app-routes
  (GET "/time" []
       (str "The current time is " (new java.util.Date)))
  (GET "/test" []
)
  (GET "/" [] "Hello World")
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

