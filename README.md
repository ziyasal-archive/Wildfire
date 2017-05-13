WildFire
=================
> Designing scalable, performant and high fault tolerance system that scales to handle high(m's) load. 

**Motivation**  
Aim to discuss system and software design patterns and implement DevOps friendly example scenario following proposed principles. 

### Principles of Distributed System Design (In progress)
_not in particular order_
 * High-availability
 * Performance
 * Scalability
 * Manageability
 * Reliability
 * Cost

**TODO:** _summary_
 
 
# Components (In progress)
 * [DNS]()
 * [CDN]()
 * [LoadBalancers]()
   - L4 (Transport)
   - L7 (Application)
 * [WebServer & Reverse Proxy]()
   - Kestrel
   - Nginx
 * [RDBMS]()
   - MSSQL (on Linux)
   - Postgres
 * [NOSQL and Graph DB's]()
   - Cassandra
   - Couchbase
   - DynamoDB
   - Neo4j
 * [Message Queues]()
 * Search
   - Elasticsearch
   - Neo4j (Graph-Based Search)
 * [Caching]()
   - Varnish
   - Redis
   - Elasticache

## Example Scenario Suggestions
* Realtime Backend as a Service
* E-Commerce
* Messaging service for online gaming
* ...

## Example scenario (In progress)
E-Commerce
============================
> Sample application is cross-platform either at the server and client side and the architecture proposes a simplified microservice oriented architecture implementation with multiple autonomous microservices (each one owning its own data/db and of course we will be discussing pros/cons later on) and implementing different approaches within each microservice using different programming languages.

**Sample (In progress)**  
<!--- ![e-commerce](https://github.com/ziyasal/Wildfire/blob/master/pencil/e-shop.png) --->

### Application Architecture  
```sh
#TODO
```

### CI/CD (In progress)  
> Everything will be implemented as "Pipeline as Code"

```sh
#TODO
```

### Infrastructure (In progress)  
> Kubernetes on AWS will be used (There is a plan to create Terraform templates for other vendors if I have time.)

**Cluster provisioning**  
**AWS integration**  
**Ingress**  
**Cluster autoscaling**  
**OAuth/IAM**  
**Operations/monitoring**  

#### Steps  
- Create ectd cluster seperately
- Use [kops](https://github.com/kubernetes/kops) to create Kubernetes cluster on AWS
- TODO:

## 
```sh
#TODO
```

License @MIT
