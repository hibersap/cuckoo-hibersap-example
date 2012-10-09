package de.akquinet.jbosscc.cuckoo.example.model;

import org.hibersap.annotations.Bapi;
import org.hibersap.annotations.Import;
import org.hibersap.annotations.Parameter;
import org.hibersap.annotations.Table;

import java.util.List;

@Bapi( "BAPI_FLCUST_GETLIST" )
public class CustomerSearch
{
    @Import
    @Parameter( "CUSTOMER_NAME" )
    private String nameSearchPattern;

    @Import
    @Parameter( "MAX_ROWS" )
    private int maxRows;

    @Table
    @Parameter( "RETURN" )
    private List<ReturnMessage> returnMessages;

    @Table
    @Parameter( "CUSTOMER_LIST" )
    private List<CustomerWithId> customers;

    public CustomerSearch( String nameSearchPattern, int maxRows )
    {
        this.maxRows = maxRows;
        this.nameSearchPattern = nameSearchPattern;
    }

    public List<CustomerWithId> getCustomers()
    {
        return customers;
    }

    public List<ReturnMessage> getReturnMessages()
    {
        return returnMessages;
    }
}
