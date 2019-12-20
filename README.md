This is an example project for a Java EE application written in Kotlin using Hibersap and the Cuckoo Resource Adapter for SAP.
The application implements a search for customers from the Flight Booking demo application in SAP.
The application has REST endpoints for searching customers and for changing the data of an individual customer in SAP.

The project shows how easy it is to call SAP functions from within EJBs making use of Container Managed Transactions.
It calls function module BAPI_FLCUST_GETLIST to search customers and BAPI_FLCUST_CHANGE to change the customer data.

The application uses the HibersapSessionInterceptor on an EJB to automatically inject a Hibersap Session.
The Interceptor will take care of correctly opening and closing the Session.

A Singleton EJB is used to configure Hibersap, create a SessionManager and bind it to JNDI when the application gets started.

Example search with httpie: <code>http http://localhost:8080/customer/search/\*Forst\*</code>

More info for the individual projects can be found here:
- Hibersap: http://www.hibersap.org
- Cuckoo: http://sourceforge.net/p/cuckoo-ra
