package de.akquinet.jbosscc.cuckoo.example.model;

import org.hibersap.annotations.Bapi;
import org.hibersap.annotations.Import;
import org.hibersap.annotations.Parameter;
import org.hibersap.annotations.ParameterType;
import org.hibersap.annotations.Table;

import java.util.List;

@Bapi("BAPI_FLCUST_CHANGE")
public class CustomerChange
{
    @Import @Parameter( "CUSTOMERNUMBER" )
    private String customerId;

    @Import @Parameter( value = "CUSTOMER_DATA", type = ParameterType.STRUCTURE)
    private Customer customerData;

    @Import @Parameter( value = "CUSTOMER_DATA_X", type = ParameterType.STRUCTURE)
    private Customer customerDataX;

    @Table @Parameter( "RETURN" )
    private List<ReturnMessage> returnMessages;

    public CustomerChange( String customerId, Customer customer )
    {
        this.customerId = customerId;
        this.customerData = customer;
        this.customerDataX = new Customer();

        // tells SAP that all field shall be changed
        customerDataX.setCity( "X" );
        customerDataX.setCountryKeyIso( "X" );
        customerDataX.setEmail( "X" );
        customerDataX.setFormOfAddress( "X" );
        customerDataX.setName( "X" );
        customerDataX.setPhoneNumber( "X" );
        customerDataX.setPoBox( "X" );
        customerDataX.setPostalCode( "X" );
        customerDataX.setRegion( "X" );
        customerDataX.setStreet( "X" );
    }

    public List<ReturnMessage> getReturnMessages()
    {
        return returnMessages;
    }
}
