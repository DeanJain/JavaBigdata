
## GCP - Google Cloud Platform

### Google COMPUTE ENGINE - Raw Vms

##### login to compute vm instance 
gcloud beta compute ssh --zone "us-central1-a" "unicorn-instance-1" --project "perfect-transit-278123"

##### stop instance 
gcloud compute instances stop unicorn-instance-1

##### start instance 
gcloud compute instances start unicorn-instance-1


##### create GCP  compute template from existing vm instance
gcloud compute instance-templates create basic-vm-instance-template \
    --source-instance=unicorn-instance-1 \
    --source-instance-zone=us-central1-a

##### existing instance details
gcloud compute instances list


### GAE APP ENGINE: Platform as a Service PaaS - Deploy your Apps from your code / github etc to STD Image

##### create blank app instance
gcloud app create

get the code in local and make sure it has app.yaml
git clone \
    https://github.com/GoogleCloudPlatform/golang-samples

    cd \
    golang-samples/appengine/go11x/helloworld

##### deploy the code for go app into the GAE
gcloud app deploy

##### You can stream logs from the command line by running:
  $ gcloud app logs tail -s default


### Kubernetes - Managed Containers on docker / Kubernetes

- Master and Node, Node is worker, Each Node can Have a Service, Service can have multiple pods, each pods can have multiple containers

- Node (Inside a Node Pool) --> Service --> 1+ Pods --> 1+  Containers

- Deployments (uses pod templates) --> set of Multiple identical pods 

##### Set Auth for GCP on local:

```yaml
gcloud container clusters get-credentials dean-kube-cluster-1 --zone us-central1-c

   gcloud container clusters  list

   gcloud container clusters describe dean-kube-cluster-1 --zone us-central1-c

   kubectl config current-context

   kubectl create -f examples/guestbook-go/redis-master-controller.json

   kubectl get rc
   kubectl get pods

   kubectl create -f examples/guestbook-go/redis-master-service.json
   kubectl get services
   kubectl create -f examples/guestbook-go/redis-slave-controller.json
   kubectl get services
   kubectl get rc

   kubectl get services
   kubectl get pods
   kubectl create -f examples/guestbook-go/redis-slave-service.json
   kubectl get services
   kubectl create -f examples/guestbook-go/guestbook-controller.json
   kubectl get rc
   kubectl get pods
   kubectl create -f examples/guestbook-go/guestbook-service.json
   kubectl get services
   kubectl get services --watch
```

### GCP Databases:

- Cloud SQL -> RDBMS - MySQL/ PostGres / SQLServer - 10 tb data, 208 gb ram, 32 cores
- Spanner - Google RDBMS / SQL which is horizontally scalable - the best RDBMS on planet
- Bigtable - Hbase bigdata key value pair columnar storage 
- Cloud Datastore - Document DB like MOngo
- Cloud Storage - File Storage / Object store
	* cloud storage life cycle - > store std --> after 6 months move to nearline storage 1 year --> coldline storage 5 yr - delete it
	* like S3
	* store immutable files, read it and delete it, cant edit, archive it 
	* 11 9s durability
	* cloud storage is HDFS compliant same way we can read files like hadoop - hdfs:// vs gs://
	* cloud object notification --> pubsub or functions 

### GCP Bigdata:

- Bigtable - HBase kind...
- BigQuery - EDW Enterprise data warehose
- Dataflow -  Apache Beam impl
- DataProc  - Hadoop / Spark Cluster
- Datalab - Analytical / Visual tool 
- Pub/Sub - Event Driven like kafka

- BigTable: HBase
   * Regional	resource	scope
   * Managed	NoSQL
   * Scalable	but	not	serverless
   * Powers	well-known apps like gmail, maps etc
   * HBase	compatible*
   * Great	for	many	concurrent	reads/writes

- BigQuery:  DatawareHouse
    * Regional	resource	scope
    * Managed	Data	Warehouse
    * Scales	to	Petabytes
    * SQL	(ANSI:2011)	compliant
    * Dedicated	CLI
    * Separate	compute	and	storage	tiers
    * Integrates	and	ML	and	BI	offerings

- Cloud	DataStore/Firestore
    * Regional	or	multi-regional	resource	scope
    * Cloud-native	NoSQL
    * Strong	mobile	support
    * Offline	support	for	clients
    * Documents	and	collections
    * ACID	compliance
    
- Cloud	DataFlow     
    * Zonal	and	Regional	resource	scope
    * Managed	Apache	Beam
    * Batch	or	streaming	data	pipelines
    * For	Hadoop	use	DataProc	instead