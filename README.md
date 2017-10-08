# CustomerManagement_RAML
CustomerManagement System using RAML

## Springboot application
Simple Springboot application have been developed to practically show GET,PUT,POST,DELETE actions.

mvn clean install -DskipTests

run CustomermanagementApplication class to start the Springboot application
or java -jar target/customermanagement-0.0.1-SNAPSHOT.jar

run selected (testAll) tests from CustomerManagementServiceTest to see actions. Other option is to use any other rest clients/test tools like postman.

# RAML
RAML is developed using Atom api-workbench

RAML spec can be found in RAML/customerManagement.raml along with sample files (customers.sample, customer.sample)

##### 1.A consumer may periodically (every 5 minutes) consume the API to enable it (the consumer) to maintain a copy of the provider API's customers (the API represents the system of record)

 1. Caching techniques such as If-Modified-Since, etags can be used. If response contains If-Modified-Since or etags in headers then client can take advantage of it and send that information in subsequent GET calls to retrieve only updated data. Server can determines that client has up-to-date representation of the resource and return only changed data/information.


##### 2. A mobile application used by customer service representatives that uses the API to retrieve and update the customers details

1. Paging with sorting is a good technique to retrieve limited amount of data in each call. This will reduce bandwidth usage.
2. API should provide enough information for a mobile client so it doesn't require make multiple calls.
3. Caching techniques such as Cache-Control, If-Modified-Since, etags can be used to limit network traffic.

##### 3. Simple extension of the API to support future resources such as orders and products

1. Orders and Products can be sub-resources under customer. This is more convenient way to find out Orders and products in each order that a customer has.
2. Alternatively Orders and Products can be separate resources. This is good to find out Orders and Products by passing queryParameters. Products as its own resource enables to list all available product and query with queryParameters.
