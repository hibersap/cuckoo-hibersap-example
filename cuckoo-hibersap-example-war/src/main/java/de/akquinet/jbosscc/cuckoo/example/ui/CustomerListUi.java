package de.akquinet.jbosscc.cuckoo.example.ui;

import de.akquinet.jbosscc.cuckoo.example.model.Customer;
import de.akquinet.jbosscc.cuckoo.example.model.CustomerWithId;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class CustomerListUi implements Serializable
{
    private static final long serialVersionUID = -2403138958014741653L;

    private final List<CustomerWithId> customers = new ArrayList<CustomerWithId>();

    public List<CustomerWithId> getCustomers()
    {
        return customers;
    }

    public void setCustomers( List<CustomerWithId> customers )
    {
        this.customers.clear();
        this.customers.addAll( customers );
    }
}
