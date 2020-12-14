
<<<<<<< HEAD

=======
>>>>>>> 7479778b4675fef5d50348eba564c9dd95099e14
# While virtual machines virtualize hardware, containers virtualize the operating system.

Containers bring the following advantages:

- Isolation: Applications can use their own libraries without conflicting with libraries from other applications.
- Resource limitation: Applications can be limited to the resource's usage.
- Portability: Applications are self-contained with all dependencies and are not tied to an OS or a cloud provider.
- Lightweight: The footprint of the application is much smaller as the containers share a kernel.

<<<<<<< HEAD
## Docker 
There are multiple container formats available on the market. Docker is an open platform and allows you to develop and run containerized applications. It can run on multiple Linux images offered in GCP as they have the same kernel. Docker images are created using a definition called a Dockerfile.

=======
## Docker Images
  
>>>>>>> 7479778b4675fef5d50348eba564c9dd95099e14
 - Immutable   
 - Everything the service needs (but not more)   
 - Inside a Docker registry
-   Docker's Multi-Stage Builds
-   Allows execution of multiple stages while maintaining small size of the final image
-   We run unit tests and we built the application binary
-   The result of the first stage (the binary) was used in the final stage to assemble the image
- Push the built image to a docker registry

##### Microservices on Kubernetes / Docker:
- Docker hosts the API bundle as docker file / images
- Kubernetes manages docker images to create a highly scalable cluster of PODS, it orchestrates the life and times of individual Docker containers, giving us the primitives we need to construct robust and scalable systems.
- It has many features which are especially useful for applications running in production, like service naming and discovery, load balancing, application health checking, horizontal auto-scaling, and rolling updates.
- MiniKube is the software you can install to have Kubernetes on local mac, You can create a minikube cluster of multiple pods within which will be all images of a provided docker image file
- API Gateway can be created by using ambassador or Ingress on Kube	 

## Kubertnetes 
Kubernetes, also known as K8s, is an open source container orchestrator that was initially developed by Google and donated to the Cloud Native Computing Foundation. It allows you to deploy, scale, and manage containerized applications. As an open source platform, it can run on multiple platforms both on-premise as well as in the public cloud. It is suitable for both stateless as well as stateful applications.

![K8s](static/K8s.png)

![Kube Deployment](static/KubeDeploy.png)

### MiniKube

- Install minikube + Basic commands:

 `` minikube start --vm-driver virtualbox --cpus 4 --memory 4096
    minikube status
    minikube dashboard
    minikube docker-env
    eval $(minikube docker-env)
    docker container ls``
    
    
    minikube ssh
    docker container ls
    exit
    kubectl config current-context
    kubectl get nodes
    minikube stop
    minikube start
    minikube delete`

Resource types are defined in the Kubernetes APIs
• Pods: the basic unit in Kubernetes, represents a set of containers that share common resources such as an IP address and storage volumes
• Deployments: standard entity that is rolled out with Kubernetes
• Services: make deployments accessible from the outside by providing a single IP/port combination. Services by default provide access to pods in round-robin fashion using a load balancer
• Persistent Volumes: persistent (networked) storage that can be mounted within a container by using a Persistent Volume Claim

When	running	 a	deployment,	 Pods	have	an	internal	network	address	in	the	172.17.0.0/16	network

The	service	connects	to	the	Pods	internal	IP	addresses	by	making	them	endpoints
    
### Istio 

##### ServiceMesh – Kubernetes, Istio, Conduit, Envoy and Consul

###### Features:		
- Load balancing
- Fine-grained traffic policies
- Service discovery
- Service monitoring
- Tracing
- Routing
- Secure service to service communication
    
###### Implementations:        
- Conduit is a service mesh based on Go and Rust for proxying
- Istio is also a service mesh based on Go, it uses	Envoy Proxy for Data plane, Istio (Pilot, Mixer and Citadel) for Control plane
- Consul can also act as control plane with Envoy proxy as Data plane it can create a very flexible and powerful servicemesh

