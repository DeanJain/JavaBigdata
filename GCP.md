
## GCP - Google Cloud Platform

- Hierarchy    
    Organization
        Folders (grouping within org)
        Project --> Billing account
            Resources  --> Labels (k:v)
            
- Internals            
    - Zone Availability zone (similar to a datacenter) 
    - Region Set of zones with high-speed network links 
    - Network User-controlled IP addresses, subnets and firewalls  
    
    - Global:
        - Static external IP addresses 
        - Images and snapshots
        - Networks,firewalls,routes
    - Regional 
        - Subnets
        - Regional persistent disks
    - Zonal
        - Instances
        - Persistent disks
   
Persistent Disks
   - Block storage
   - Max 64TB in size
   - Pay what you allocate
   - Tied to GCE VMs
   - Zonal or regional access
   - Resize on the  fly
   - Move across zones
   - Create images and snapshots 
   - Encrypted at rest
   
Buckets
   - Object storage
   - Infinitely scalable
   - Pay what you use
   - Independent of GCE VMs
   - Global access

Image
- Binary file used to instantiate VM rootdisk 
- Usually based off OS image
- Also contains bootloader
- Can also contain customizations
- Managed by GCP image service   

Snapshot
- Binary file with exact contents of persistent disk 
- “Point-in-time” snapshot
- Managed by GCP snapshot service
- Incremental backups possible too
- Used to back up data from persistent disks
    
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

Standard 
- App runs in a proprietary sandbox VM 
- Instances start up in seconds 
- Code in few languages/versions only 
- No other runtimes possible 
- Apps cannot access Compute Engine resources 
- No installation of third-party binaries 

Flexible 
- Instance start up in minutes 
- Code in far more languages/ versions 
- Custom runtimes possible
- Apps can access Compute Engine resources, some OS packages
- Can install and access third-party binaries 

### Storage Usecases

|     Use Case                                              |     Appropriate GCP Service              |     Non-GCP Equivalents                      |
|-----------------------------------------------------------|------------------------------------------|----------------------------------------------|
|     Block storage                                         |     Persistent disks   or local SSDs     |     AWS   EBS, Azure Disk                    |
|     Object/blob   storage                                 |     Cloud Storage   (GCS) buckets        |     AWS   S3, Azure Blob Storage             |
|     Relational data -   small, regional payloads          |     Cloud SQL                            |     AWS   RDS, Azure SQL Database            |
|     Relational data -   large, global payloads            |     Cloud Spanner                        |                                              |
|     HTML/XML documents   with NoSQL access                |     Firestore                            |     AWS   DynamoDB, Azure Cosmos DB          |
|     Large, naturally   ordered data with NoSQL access     |     BigTable                             |                                              |
|     Analytics and   complex queries with SQL access       |     BigQuery                             |     AWS   Redshift, Azure Data Warehouse     |



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

- Cloud SQL -> RDBMS - MySQL/ PostGres / SQLServer - 10 tb max data, 208 gb ram, 32 cores, Transactional support, ACID support


- Spanner - Google RDBMS / SQL horizontally scalable - the best RDBMS on the Planet


- Big table - Hbase bigdata key value pair columnar storage 


- Cloud Datastore - Document DB like MOngo


- Cloud Storage - File Storage / Object store
	* cloud storage life cycle - > store std --> after 6 months move to nearline storage 1 year --> coldline storage 5 yr - delete it
	* like S3
	* store immutable files, read it and delete it, cant edit, archive it 
	* 11 9s durability
	* cloud storage is HDFS compliant same way we can read files like hadoop - hdfs:// vs gs://
	* cloud object notification --> pubsub or functions 

- Cloud Firestore : Flexible, scalable, NoSQL database for keeping data in sync across client apps, Mobile and web server development, Realtime listeners

 

### GCP Bigdata:

- Bigtable - HBase kind...
- BigQuery - EDW Enterprise data warehose
- Dataflow -  Apache Beam impl
- DataProc  - Hadoop / Spark Cluster
- Datalab - Analytical / Visual tool 
- Pub/Sub - Event Driven like kafka

- BigTable: HBase - sequential ordering in key column; provides very fast writes as well as reads
   * Regional	resource	scope
   * Managed	NoSQL
   * Scalable	but	not	serverless
   * Powers	well-known apps like gmail, maps etc
   * HBase	compatible*
   * Great	for	many	concurrent	reads/writes

- BigQuery:  Serverless Data Warehouse RDBMS
    * Regional	resource	scope
    * OLAP
    * Scales	to	Petabytes
    * SQL	(ANSI:2011)	compliant
    * Dedicated	CLI
    * Separate compute and storage	tiers
    * Integrates with ML and BI	offerings

- Cloud	DataStore/Firestore (Mongo kind ??)
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
   
#### Google Virtual Private Cloud
 A VPC network is a global, private, isolated virtual network partition that provides managed network functionality on the GCP

- VPC are global
- Subnet in each region
- resources are provisioned on the subnet
- Each VPC must exist inside a project
- Default VPC pre-created in each project 
- Can add additional VPCs
    - AutoMode
    - CustomMode                

Subnets
- IP range partitions within global VPCs
- VPCs have no IP ranges
- Subnets are regional - can span zones inside a region
- Network has to have at least one subnet before you can use it
- Each subnet must have primary address range 
- Valid RFC 1918 CIDR block
- Subnet ranges in same network cannot overlap
- Subnet ranges in different networks can overlap    
    