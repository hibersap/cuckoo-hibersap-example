package de.akquinet.jbosscc.cuckoo.example.ejb;

import de.akquinet.jbosscc.cuckoo.example.model.Customer;
import de.akquinet.jbosscc.cuckoo.example.model.CustomerSearch;
import de.akquinet.jbosscc.cuckoo.example.model.ReturnMessage;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CustomerService
{
    CustomerSearch search( String nameSearchPattern, int maxRows );

    List<ReturnMessage> store( String customerId, Customer customer );
}
