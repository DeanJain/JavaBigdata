
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

A Kubernetes cluster has two types of instances: cluster masters and nodes.

- The cluster master runs four core services that are part of the control plane: controller manager, API server, scheduler, and etcd.
- The controller manager runs services that manage Kubernetes abstract components, such as deployments and replica sets.
- Applications interacting with the Kubernetes cluster make calls to the master using the API server. The API server also handles intercluster interactions.
- The scheduler is responsible for determining where to run pods, which are low-level compute abstractions that support containers.
- ectd is a distributed key-value store used to store stateStatefulSets information across a cluster.
- Nodes are instances that execute workloads. They communicate with the cluster master through an agent called kubelet
- Master and Node, Node is worker, Each Node can Have a Service, Service can have multiple pods, each pods can have multiple container

- Node (Inside a Node Pool) --> Service --> 1+ Pods --> 1+  Containers
- Deployments (uses pod templates) --> set of Multiple identical pods 
- ReplicaSet - Scaling and healing
- Deployment - Versioning and rollback
- Service - Static(non-ephemeral) IP addresses,  Stable networking
- Persistent volumes - Non-ephemeral storage
- StatefulSets - used to designate pods as stateful and assign a unique identifier to them. Kubernetes uses these to track which clients are using which pods and to keep them paired

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

#### Cloud Functions
Cloud Functions use three components: events, triggers, and functions. An event is an action that occurs in the GCP. Cloud Functions does not work with all possible events in the cloud platform; instead, it is designed to respond to five kinds of events.
   - Cloud Storage
   - Cloud Pub/Sub
   - HTTP
   - Firebase
   - Stackdriver Logging

A trigger in Cloud Functions is a specification of how to respond to an event. Triggers have associated functions. Currently, Cloud Functions can be written in Python 3, Go, and Node.js 8 and 10.

#### Deployment Manager 
service that allows you to specify infrastructure as code. It is a good practice to define infrastructure as code, since it allows teams to reproduce environments rapidly. It also lends itself to code reviews, version control, and other software engineering practices.


#### The gsutil command is used only for Cloud Storage.

#### gcloud command, you can interact with other Google Cloud products like the App Engine, Google Kubernetes Engine etc. 

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

- Cloud Memorystore
    * Reduce latency with scalable, secure, and highly available in-memory service for Redis and Memcached.

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
    
- Dataflow -  Apache Beam impl for ETL and Streaming both - unified programming for both batch and streaming. dynamic workflow rebalancing, fully managed and auto scales. Developers can write stream and batch processing code using Java, Python, and SQL. If you need to process the data, for example applying transformations to a stream of IoT data, then Cloud Dataflow is good option.

- DataProc  - Hadoop / Spark Cluster for batch / hadoop only, Use Google Cloud Dataproc, a managed Spark and Hadoop service, to easily process big datasets using the powerful and open tools in the Apache big data ecosystem.

- Datalab - Analytical / Visual tool, interactive notebook (based on Jupyter) to explore, collaborate, analyze and visualize data. It is integrated with BigQuery and Google Cloud Machine Learning to give you easy access to key data processing services

- Pub/Sub - 
- Event Driven and is a message queue (e.g. Rabbit MQ), serverless, large scale, reliable, real-time messaging service that allows you to send and receive messages between independent applications, 
- You can leverage Cloud Pub/Sub’s flexibility to decouple systems and components hosted on Cloud Platform or elsewhere on the Internet. 
- By building on the same technology Google uses, Cloud Pub/Sub is designed to provide “at least once” delivery at low latency with on-demand scaling to tens of millions of messages per second.
- It supports both push and pull subscriptions.
- *With a push subscription, message data is sent to by HTTP POST request to a push endpoint URL. The push model is useful when a single endpoint processes messages from multiple topics.* 
- It’s also a good option when the data will be processed by an App Engine Standard application or a Cloud Function. Both of those services bill only when in use, and *pushing a message avoids the need to check the queue continually for messages to pull.*
- With a pull subscription, a service reads messages from the topic. This is a good approach when processing large volumes of data and efficiency is a top concern.


#### Stackdriver 

- Logging receives, indexes, and stores log entries from many sources, including Google Cloud Platform, Amazon Web Services, VM instances running the Stackdriver Logging fluentd agent, and user applications.
- All log entries in Stackdriver Logging are represented using a single data type, LogEntry, which defines certain common data for all log entries as well as carrying individual payloads.

- Stackdriver Trace is a distributed tracing system for Google Cloud Platform that collects latency data from Google App Engine, Google HTTP(S) load balancers, and applications instrumented with the Stackdriver Trace SDKs, and displays it in near real time in the Google Cloud Platform Console.
- It helps you understand how long it takes your application to handle incoming requests from users or other applications, and how long it takes to complete operations like RPC calls performed when handling the requests.
- Currently, Stackdriver Trace collects end-to-end latency data for requests to App Engine URIs and additional data for round-trip RPC calls to App Engine services like Datastore, URL Fetch, and Memcache.


#### Designing a solution infrastructure that meets business requirements. 
- Business use cases and product strategy
- Cost optimization
- Supporting the application design
- Integration
- Movement of data
- Tradeoffs
- Build, buy or modify
- Success measurements (e.g., Key Performance Indicators (KPI), Return on Investment (ROI), metrics)
- Compliance and observability


#### IMPROVING COMPLIANCE WITH INDUSTRY REGULATIONS
- Health Insurance Portability and Accountability Act (HIPAA), a healthcare regulation
- Children’s Online Privacy Protection Act (COPPA), a privacy regulation
- Sarbanes-Oxley Act (SOX), a financial reporting regulation
- Payment Card Industry Data Standard (PCI), a data protection regulation for credit card processing
- General Data Protection Regulation (GDPR), a European Union privacy protection regulation

- Service-Level Agreement (SLA) An agreement between a provider of a service and a customer using the service. SLAs define responsibilities for delivering a service and consequences when responsibilities are not met.

- Service-Level Indicator (SLI) A metric that reflects how well a service-level objective is being met. Examples include latency, throughput, and error rate.

- Service-Level Objective (SLO) An agreed-upon target for a measurable attribute of a service that is specified in a service-level agreement.

#### Cloud TCO 
The combination of all expenses related to maintaining a service, which can include the following:
- Software licensing costs
- Cloud computing costs, including infrastructure and managed services
- Cloud storage costs
- Data ingress and egress charges
- Cost of DevOps personnel to develop and maintain the service
- Cost of third-party services used in an application
- Charges against missed service-level agreements
- Network connectivity charges, such as those for a dedicated connection between an on-premises data center and Google Cloud



### Google Architect Certification Case Studies:

#### Dress4Win https://cloud.google.com/certification/guides/cloud-architect/casestudy-dress4win-rev2

Existing:
- wardrobe using a web app and mobile application
- active social network that connects their users with designers and retailers
- several hundred servers and appliances in a collocated data center
- infrastructure is now insufficient for the application’s rapid growth. 
- innovate faster, Dress4Win is committing to a full migration to a public cloud.
- moving their development and test environments
- building a disaster recovery site 
- servers run Ubuntu LTS v16.04
- MySQL: 1 server for user data, inventory, and static data
- Redis: 3 server cluster for metadata, social graph, and caching
- 40 Web application servers providing micro-services based APIs and static content.
- 20 Apache Hadoop/Spark servers for Data analysis and Real-time trending calculations
- 3 RabbitMQ servers for messaging, social notifications, and events

Business Requirements
- Build a reliable and reproducible environment with scaled parity of production.
- Improve security by defining and adhering to a set of security and Identity and Access Management (IAM) best practices for the cloud.
- Improve business agility and speed of innovation through rapid provisioning of new resources.
- Analyze and optimize architecture for performance in the cloud.

Technical Requirements
- Easily create non-production environments in the cloud.
- Implement an automation framework for provisioning resources in cloud. Implement a continuous deployment process for deploying applications to the on-premises data center or cloud.
- Support failover of the production environment to the cloud during an emergency.
- Encrypt data on the wire and at rest.
- Support multiple private connections between the production data center and cloud environment.

Observations:
Our traffic patterns are highest in the mornings and weekend evenings; during other times, 80 percent of our capacity is sitting idle.
Our capital expenditure is now exceeding our quarterly projections
total cost of ownership (TCO) analysis over the next five years for a public cloud strategy achieves a cost reduction of 30–50 percent over our current model



- Mountkirk Games https://cloud.google.com/certification/guides/cloud-architect/casestudy-mountkirkgames-rev2
Existing:
- online, session-based, multiplayer games for mobile platforms
- popularity of some of their games, they have had problems scaling their global audience, application servers, MySQL databases, and analytics tools
- write game statistics to files and send them through an ETL tool that loads them into a centralized MySQL database for reporting
- plan to deploy the game’s backend on the Google Compute Engine so that they can capture streaming metrics, run intensive analytics, and take advantage of its autoscaling server environment and integrate with a managed NoSQL database.

Business Requirements
- Increase to a global footprint
- Improve uptime (downtime is loss of players)
- Increase efficiency of the cloud resources they use
- Reduce latency to all customers

Technical Requirements
- Requirements for Game Backend Platform
    - Dynamically scale up or down based on game activity.
    - Connect to a transactional database service to manage user profiles and game state.
    - Store game activity in a time series database service for future analysis.
    - As the system scales, ensure that data is not lost due to processing backlogs.
    - Run hardened Linux distro.

- Requirements for Game Analytics Platform
    - Dynamically scale up or down based on game activity.
    -  Process incoming data on the fly directly from the game servers.
    -  Process data that arrives late because of slow mobile networks.
    -  Allow queries to access at least 10 TB of historical data.
    -  Process files that are regularly uploaded by users’ mobile devices.
    
Observations:    
 - Our investors want more key performance indicators (KPIs) to evaluate the speed and stability of the game, as well as other metrics that provide deeper insight into usage patterns
 - our current technology stack cannot provide the scale we need, so we want to replace MySQL and move to an environment that provides autoscaling, low-latency load balancing, and frees us up from managing physical servers.


- TerramEarth https://cloud.google.com/certification/guides/cloud-architect/casestudy-terramearth-rev2
Existing:
- manufactures heavy equipment for the mining and agricultural industries
- currently have over 500 dealers and service centers in 100 countries
- 20 million TerramEarth vehicles in operation that collect 120 fields of data per second
- 200,000 vehicles are connected to a cellular network, allowing TerramEarth to collect data directly
- collects a total of about 9 TB of data per day from these connected vehicles 200,000
- systems gzip CSV files from the field, upload via FTP, and place the data in their data warehouse. 
- reports are based on data that is three weeks old due to delay
- because the data is stale, some customers are without their vehicles for up to four weeks

Business Requirements
- Decrease unplanned vehicle downtime to less than one week
- Support the dealer network with more data on how their customers use their equipment to position new products and services better.
- Have the ability to partner with different companies—especially with seed and fertilizer suppliers in the fast-growing agricultural business—to create compelling joint offerings for their customers.

Technical Requirements
- Expand beyond a single data center to decrease latency to the American Midwest and east coast
- Create a backup strategy
- Increase security of data transfer from equipment to the data center
- Improve data in the data warehouse
- Use customer and equipment data to anticipate customer needs

