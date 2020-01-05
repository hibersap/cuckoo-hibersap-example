This is an example project for a Java EE application written in Kotlin using Hibersap and the Cuckoo Resource Adapter for SAP.
The application implements a search for customers from the Flight Booking demo application in SAP.
The application has REST endpoints for searching customers and for changing the data of an individual customer in SAP.

The project shows how easy it is to call SAP functions from within EJBs making use of Container Managed Transactions.
It calls function module BAPI_FLCUST_GETLIST to search customers and BAPI_FLCUST_CHANGE to change the customer data.

The application uses the HibersapSessionInterceptor on an EJB to automatically inject a Hibersap Session.
The Interceptor will take care of correctly opening and closing the Session.

A Singleton EJB is used to configure Hibersap, create a SessionManager and bind it to JNDI when the application gets started.

### Building and Running the Application

You need a SAP Java Connector library installed in a local Maven repository or deployed to a remote repo with the coordinates org.hibersap:com.sap.conn.jco.sapjco3:3.1.2

You need the corresponding native library for Linux on x86 / 64bit installed with the above Maven coordinates with type `so` and classifier `linuxx86_64`.

You need a SAP ABAP system running.

In `wildfly/add-resource-adapter.cli`, change the values for username, passwort, jcoClient, jcoSystemNumber and jcoApplicationServerHost to the values reflecting your SAP system.   

To build the project and a ready-to-use docker image with a Wildfly application server running the example application, run `mvn clean install` from the command line.

To start the Docker container run `docker-compose up`.

For example REST calls see file `cuckoo.http`. When openend in IntelliJ IDEA, the HTTP calls can be executed from the editor.

More info for the individual projects can be found here:
- Hibersap: http://www.hibersap.org
- Cuckoo: http://sourceforge.net/p/cuckoo-ra
