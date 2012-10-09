package de.akquinet.jbosscc.cuckoo.example.ui;

import de.akquinet.jbosscc.cuckoo.example.ejb.CustomerService;
import de.akquinet.jbosscc.cuckoo.example.model.CustomerSearch;
import de.akquinet.jbosscc.cuckoo.example.model.ReturnMessage;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class CustomerSearchUi implements Serializable
{
    private static final long serialVersionUID = -2403138958014741653L;

    @EJB
    private CustomerService customerService;

    @Inject
    private CustomerListUi customerList;

    private String namePattern = "*";

    private int maxRows = 10;

    public int getMaxRows()
    {
        return maxRows;
    }

    public void setMaxRows( int maxRows )
    {
        this.maxRows = maxRows;
    }

    public String getNamePattern()
    {
        return namePattern;
    }

    public void setNamePattern( String namePattern )
    {
        this.namePattern = namePattern;
    }

    public void search()
    {
        CustomerSearch customerSearch = customerService.search( namePattern, maxRows );

        customerList.setCustomers( customerSearch.getCustomers() );

        for ( ReturnMessage sapMessage : customerSearch.getReturnMessages() )
        {
            FacesContext.getCurrentInstance().addMessage( null, new FacesMessage( sapMessage.getMessage() ) );
        }

        String msg = customerSearch.getCustomers().size() + " Customer(s) found.";
        FacesContext.getCurrentInstance().addMessage( null, new FacesMessage( msg ) );
    }
}
