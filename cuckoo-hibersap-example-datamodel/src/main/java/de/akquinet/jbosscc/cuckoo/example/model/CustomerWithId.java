package de.akquinet.jbosscc.cuckoo.example.model;

import org.hibersap.annotations.BapiStructure;
import org.hibersap.annotations.Parameter;

@BapiStructure
public class CustomerWithId extends Customer
{
    @Parameter( "CUSTOMERID" )
    private String id;

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "CustomerWithId{" +
                "id='" + id + '\'' +
                "} " + super.toString();
    }
}
