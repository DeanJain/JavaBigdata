
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

   
#### Google Virtual Private Cloud - VPC
 A VPC network is a global, private, isolated virtual network partition that provides managed network functionality on the GCP

- VPC are global
- Subnet in each region
- resources are provisioned on the subnet
- Each VPC must exist inside a project
- Default VPC pre-created in each project 
- can have upto 5 max VPC per project
- VPCs types
    - Auto Mode
    - Custom Mode  
    - Default Mode              

##### Auto Scaling & Load Balancing
 - High performance, scalable load balancing, GCP provides Global Load Balancing - Scale your applications on Google Compute Engine from zero to full-throttle. Distribute your load balanced compute resources in single or multiple regions, close to your users and to meet your high availability requirements

##### Cloud Interconnect
- Google Cloud Interconnect allows Cloud platform customers to connect to Google via enterprise-grade connections with higher availability and/or lower latency than their existing Internet connections.

##### Google Cloud CDN 
- leverages Google's globally distributed edge caches to accelerate content delivery for websites and applications served out of Google Compute Engine.
- Cloud CDN lowers network latency, offloads origins, and reduces serving costs. Once you've set up HTTP(S) Load Balancing, simply enable Cloud CDN with a single checkbox

##### Google Cloud DNS 
- scalable, reliable and managed authoritative Domain Naming System (DNS) service running on the same infrastructure as Google.
- It has low latency, high availability and is a cost-effective way to make application and services available to your users.      

#### Subnets

-  VPC Contains Subnetworks
-  Subnets are Region Specific
-  Subnet be in single zone or multiple zone within the region
-  Using Subnetworks – we can apply single firewall rules all VMs even if they are in different zone.
-  You can create multiple subnets within single region/zone to isolations resources based on different business needs.
- Each Subnet has contiguous private RFC1918 IP Space - IP Range
- Virtual machine (VM) instances in a VPC network can communicate with instances in all other subnets of the same VPC network, regardless of region, using their RFC1918 private IP addresses.
- You can isolate portions of the network, even entire subnets, using firewall rules.
- IP range partitions within global VPCs
- VPCs have no IP ranges
- Subnets are regional - can span zones inside a region
- Network has to have at least one subnet before you can use it
- Each subnet must have primary address range 
- Valid RFC 1918 CIDR block
- Subnet ranges in same network cannot overlap
- Subnet ranges in different networks can overlap    
    
 #### IP Addresses
- You can assign certain resources with IP addresses , You can assign external and internal IP addresses to Compute Engine (VM) , forwarding rule for external or internal Load balancing resp.
- Each VM has one primary – internal IP address, one or more secondary IP addresses and one external IP address
- To communicate with VM within VPC you can use internal IP address and to communicate with internet you must use external IP address
- Both internal and external IP addresses can be static or ephemeral

#### Routes
- All network have automatically created routes to the internet and IP range in network
- The subnet routes let instances send traffic to any other instance or resource in the same VPC network.
- The default route let instances send traffic outside the VPC n/w
- Name automatically generated
- Applies to traffic egressing a VM
- Forward traffic to most specific route
- Traffic is delivered only if it also matched a firewall rules (ingress)
- Created when subnet is created
- Applies to tagged VM as well
- Enable VM on same subnet to communicate

#### Firewall Rules

- Each network has its own firewall controlling access to and from the instances
- You can have “allow” rules , no “deny’ rules
- The default network has automatically created firewall rules that are shown in default firewall rules
- No manually created network has automatically created firewall rules except for a default "allow" rule for outgoing traffic and a default "deny" for incoming traffic.
- Tags :
    - Rules can match tags
    - Tags are used defined Strings
    - Tags are applied to VM and not to IP.

#### Shared VPC
- You may need to put different departments or different applications into different projects for purposes of separating budgeting, access control, and so on
- With Shared VPC, Cloud Organization administrators can give multiple projects permission to use a single, shared VPC network and corresponding networking resources
 

### Cloud IAM
- Roles   diff roles defined
- Member  who can get access
- Policy  join both roles to member 
    
    
GCP Identities:
- Google accounts
- Service accounts
- Google groups
- GSuite domains
- Cloud Identity domains

    
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

• ReplicaSet - Scaling and healing
• Deployment - Versioning and rollback
• Service - Static(non-ephemeral) IP addresses,  Stable networking
• Persistent volumes - Non-ephemeral storage

#### Workloads on Kubernetes

- Stateless applications
   • Does not preserve state, saves no data to persistent disk
   • Deployed using the Deployment object
- Stateful applications
   • State is saved or persisted, uses persistent volumes
   • Deployed using the StatefulSet object
- Batch jobs
   • Finite, independent, parallel jobs
   • Deployed using the Job object
- Daemons
    • Ongoing, background tasks, run without intervention
    • Deployed using a DaemonSet

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

### Load Balancing

External load balancing includes four options:
- HTTP(S) Load Balancing for HTTP or HTTPS traffic,
- TCP Proxy for TCP traffic for ports other than 80 and 8080, without SSL offload
- SSL Proxy for SSL offload on ports other than 80 or 8080.
- Network Load Balancing for TCP/UDP traffic.

- For HTTP and HTTPS traffic, use:
  -  External HTTP(S) Load Balancing
  -  Internal HTTP(S) Load Balancing
- For TCP traffic, use:
  -  TCP Proxy Load Balancing
  -  Network Load Balancing
  -  Internal TCP/UDP Load Balancing
- For UDP traffic, use:
  -  Network Load Balancing
  -  Internal TCP/UDP Load Balancing

#### Google Stackdriver
Suite of ops services providing monitoring, logging, debugging, error reporting, tracing, alerting and profiling. Integrates with several third-party tools

### GCP Databases:

- Cloud SQL -> RDBMS - MySQL/ PostGres / SQLServer - 10 tb max data, 208 gb ram, 32 cores, Transactional support, ACID support

- Spanner - Google RDBMS / SQL horizontally scalable - the best RDBMS on the Planet

- Big table - Hbase bigdata key value pair columnar storage 

- Cloud Datastore/Firestore - Document DB like MongoDB, Flexible, scalable, NoSQL database for keeping data in sync across client apps, Mobile and web server development, Realtime listeners
    * Regional	or	multi-regional	resource	scope
    * Cloud-native	NoSQL
    * Strong	mobile	support
    * Offline	support	for	clients
    * Documents	and	collections
    * ACID	compliance

- Cloud Storage - File Storage / Object store
	* cloud storage life cycle - > store std --> after 6 months move to nearline storage 1 year --> coldline storage 5 yr - delete it
	* like S3
	* store immutable files, read it and delete it, cant edit, archive it 
	* 11 9s durability
	* cloud storage is HDFS compliant same way we can read files like hadoop - hdfs:// vs gs://
	* cloud object notification --> pubsub or functions 


### GCP Bigdata:

- Bigtable - HBase kind...sequential ordering in key column; provides very fast writes as well as reads
   * Regional	resource	scope
   * Managed	NoSQL
   * Scalable	but	not	serverless
   * Powers	well-known apps like gmail, maps etc
   * HBase	compatible*
   * Great	for	many	concurrent	reads/writes
   
- BigQuery - EDW Enterprise data warehouse, fully managed, petabyte scale, low cost enterprise data warehouse for analytics, Serverless, There is no infrastructure to manage and you don't need a database administrator, so you can focus on analyzing data to find meaningful insights using familiar SQL.
    * Regional	resource	scope
    * OLAP
    * Scales	to	Petabytes
    * SQL	(ANSI:2011)	compliant
    * Dedicated	CLI
    * Separate compute and storage	tiers
    * Integrates with ML and BI	offerings
    
- Dataflow -  Apache Beam impl for ETL and Streaming both - unified programming for both batch and streaming. dynamic workflow rebalancing, fully managed and auto scales.

- DataProc  - Hadoop / Spark Cluster for batch / hadoop only, Use Google Cloud Dataproc, a managed Spark and Hadoop service, to easily process big datasets using the powerful and open tools in the Apache big data ecosystem.

- Datalab - Analytical / Visual tool, interactive notebook (based on Jupyter) to explore, collaborate, analyze and visualize data. It is integrated with BigQuery and Google Cloud Machine Learning to give you easy access to key data processing services

- Pub/Sub - Event Driven and is a message queue (e.g. Rabbit MQ), serverless, large scale, reliable, real-time messaging service that allows you to send and receive messages between independent applications, You can leverage Cloud Pub/Sub’s flexibility to decouple systems and components hosted on Cloud Platform or elsewhere on the Internet. By building on the same technology Google uses, Cloud Pub/Sub is designed to provide “at least once” delivery at low latency with on-demand scaling to tens of millions of messages per second.

