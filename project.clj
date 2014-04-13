(defproject neotest "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [org.neo4j/neo4j "2.1.0-M01"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler neotest.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]
                        [ring/ring-core "1.2.2"]
                        [ring/ring-jetty-adapter "1.2.2"]]}})
