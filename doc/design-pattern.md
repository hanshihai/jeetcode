### J2EE Design Pattern

* Intercepting Filter:
  Create pluggable filters to process common services in a standard manner without requiring changes to core request processing code, such as authentication, logging.

* Front Controller:
  Use a controller as the initial point of contact for handling a request. Control mechanisms could be managed in either a centralized manner.

* View Helper:
  A view contains formatting code, delegating its processing responsibilities to its helper classes. the help class can be implemented as JavaBeans or custom tags.

* Composite View:
  Composite View are composed of multiple atomic subviews. The classical sample is the page using Frame. We can use "include" tag in jsp to include the subviews.

* Service to Worker:
  Controllers delegate content retrieval to helpers, the helpers manage the population of the intermediate model for the view. A dispatcher is responsible for view management and dispatches the request to the different views.

* Dispatcher View:
  Controllers do not delegate content retrieval to helpers. Controllers send client's request to dispatcher. A dispatcher is responsible for view management and dispatches the request to the different views. The view can call the helper class to get the datas.

* Business Delegate:
  Use a Business Delegate to reduce coupling between presentation-tier clients and business services. The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.

* Value Object:
  Use a Value Object to encapsulate the business data. A single method call is used to send and retrieve the value object.

* Session Facade:
  Use a session bean as a facade to encapsulate the interactions between the business objects. The Session Facade manages the business objects, and provides a uniform service access layer to clients.

* Composite Entity:
  Use Composite Entity to model, represent, and manage a set of interrelated persistent objects rather than representing them as individual entity beans.

* Value Object Assembler:
  Use a Value Object Assembler to build the required model or submodel. Client can get various Business Objects by Value Object Assembler.

* Value List Handler(Iterator):
  Use a Value List Handler to control the search, cache the results, and provide the results to the client in a result set.

* Service Locator:
  Use a Service Locator object to abstract all JNDI usage and to hide the complexities of initial context creation, EJB home object lookup, and EJB object re-creation. Multiple clients can reuse the Service Locator object to reduce code complexity, provide a single point of control, and improve performance by providing a caching facility. (util class)

* Data Access Object:
  Use a Data Access Object (DAO) to abstract and encapsulate all access to the data source.

* Service Activator:
  Use a Service Activator to receive asynchronous client requests and messages. Service Activator locates and invokes the Business Object asynchronously. The classical sample is to use MDB to deal with BO.


### Design Patterns

* Adapter:
  (extend) Wrap the old Class to define the new Class and new method.

* Bridge:
  (hide impl) Separate abstract structure from implementation structure. It can provide a flexible system.

* Proxy:
  (proxy) A proxy defines the same methods with original class. The proxy should create/init the original class when client really calls the functionality of the original class.

* Decorator:
  Decorator pattern is to extend the functionality original class in a way that is transparent to the client class.

* Composite:
  1+1=1. Put the components together by "tree" structure and get the same interface.

* flyweight:
  (share) The Flyweight Design Pattern is useful when there is the need for many, many objects to exist that share some information.

* Facade:
  (uniform interface). Define an uniform interface for a set of subsystem interfaces.

* Observer:
  (publish and subscribe) The Observer pattern suggests that the observers register themselves with the services, When services change states, then can inform the observers the events.  (publish -- subscribe)

* Chain of responsibility:
  (chain) Make many objects to deal with the request in turn.

* Memento:
  (flashcopy). Keep the state of the object to recover this object in the future. 

* State:
  The action of the object is different when it has different state. (connection) 
  
* Strategy:
  (policy).  Define some policies and provide them to client. Client can change the policy without changing any implementation.  

* Mediator:
  (intermediary) define the object to catch the interactions between subsystem or objects.

* Interator:
  (interate).  Provide a way to get the elements in the object, and don't expose the inner details. 

* Template method:
  Define an abstract method, the sub class should implement it.

* Visitor:
  A visitor can add the functions into the original object without changing the original object. Separate the function implementation from object.

* command:
  Make the request to an object. The reciever can deal with it without knowing what is it. The command should know how to deal with itself.

* Interpreter:
  Define a kind of langurage and the rules about it, then give a interpreter to deal with the sentences of this langurage.