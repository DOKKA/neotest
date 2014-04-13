(ns neotest.dbutils
  (:import (org.neo4j.graphdb
            DynamicLabel
            GraphDatabaseService
            Label
            Node
            ResourceIterator
            Transaction
            factory.GraphDatabaseFactory
            schema.IndexDefinition
            schema.Schema)
           org.neo4j.tooling.GlobalGraphOperations))

(defn create-node [db]
  (try (let [tx (. db beginTx)
             l (DynamicLabel/label "Class")
             node (. db (createNode ^"[Lorg.neo4j.graphdb.Label;"(into-array [l])))]
         (. node (setProperty "name" "Ext"))
         (. tx success)
         (. tx close)
         node)))

(defn create-class-node [db name]
  (try (let [tx (. db beginTx)
             l (DynamicLabel/label "Class")
             node (. db (createNode ^"[Lorg.neo4j.graphdb.Label;"(into-array [l])))]
         (. node (setProperty "name" ^String name))
         (. tx success)
         (. tx close)
         node)))

(defn create-class-node2 [db name]
  (declare node tx)
  (try (def tx (. db beginTx))
       (let [label (DynamicLabel/label "Class")]
         (def node (. db createNode ^"[Lorg.neo4j.graphdb.Label;"(into-array [label])))
         (. node setProperty "name" name)
         (. tx success))
       (catch Exception e
         (. tx failure)
         (print (. e getMessage)))
       (finally
         (. tx close)))
  node)

(defn get-all-properties [db id]
  (try (let [tx (. db beginTx)
             node (. db getNodeById id)
             props (. node getPropertyKeys)]
         props)))


(defn get-class-node [db name]
  (try (let [tx (. db beginTx)
             l (DynamicLabel/label "Class")
             nodes (. db (findNodesByLabelAndProperty l "name" ^String name))
             iter (. nodes iterator)
             res (. iter next)]
         (. iter close)
         res)))
