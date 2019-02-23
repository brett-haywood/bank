Simple Backend Java Service

This service allows a client to view accounts and transactions on a specific account for a particular
user over a REST web interface. It is a plain vanilla service only giving access to a pre-defined set of accounts
and transactions (emulating the state at a particular date/time). For simplicity only the Spring Boot framework is used.

The service has a Maven build file and can be executed from root directory with:

mvn clean install

A selection of unit tests are run as part of the build process, these tests are in the 'src/test/...' directory
structure.

To execute the service, from the 'target' directory use:

java -jar rest-0.0.1-SNAPSHOT.jar

It is possible to interrogate the executing service using Postman application. The interface uses a 'userId' to
validate each transaction to ensure account and transaction records are correctly extracted.
To access the accounts of a particular user,
GET command on default port, http://localhost:8080/api/accounts with Json body: { userId : "1001" }
Similarly the transactions for a particular users account can be accessed with,
GET command on default port, http://localhost:8080/api/transactions with Json body: { userId : "1001", accountId : "1234" }
