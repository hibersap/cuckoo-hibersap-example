package de.akquinet.jbosscc.cuckoo.example.ui;

import de.akquinet.jbosscc.cuckoo.example.ejb.CustomerService;
import de.akquinet.jbosscc.cuckoo.example.model.CustomerWithId;
import de.akquinet.jbosscc.cuckoo.example.model.ReturnMessage;
import de.akquinet.jbosscc.cuckoo.example.model.Severity;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.faces.application.FacesMessage.SEVERITY_FATAL;
import static javax.faces.application.FacesMessage.SEVERITY_INFO;
import static javax.faces.application.FacesMessage.SEVERITY_WARN;

@SuppressWarnings( {"UnusedDeclaration"} )
@Named
@SessionScoped
public class CustomerEditUi implements Serializable
{
    @EJB
    private CustomerService customerService;

    @Inject
    private CustomerSearchUi customerSearch;

    private CustomerWithId customer;

    public CustomerWithId getCustomer()
    {
        return customer;
    }

    public void setCustomer( CustomerWithId customer )
    {
        this.customer = customer;
    }

    public void store()
    {
        List<ReturnMessage> returnMessages = customerService.store( customer.getId(), customer );

        // Show messages returned by SAP
        for ( ReturnMessage returnMessage : returnMessages )
        {
            FacesMessage.Severity severity = getMessageSeverity( returnMessage.getSeverity() );
            String message = returnMessage.getMessage();
            FacesMessage facesMessage = new FacesMessage( severity, message, null );
            FacesContext.getCurrentInstance().addMessage( null, facesMessage );
        }

        // Update the list of customers, if there was no error; else we remain in the edit popup.
        if ( FacesContext.getCurrentInstance().getMaximumSeverity().getOrdinal() < SEVERITY_ERROR.getOrdinal() )
        {
            customerSearch.search();
        }
    }

    private FacesMessage.Severity getMessageSeverity( Severity severity )
    {
        switch ( severity )
        {
            case INFO:
                return SEVERITY_INFO;
            case SUCCESS:
                return SEVERITY_INFO;
            case WARNING:
                return SEVERITY_WARN;
            case ERROR:
                return SEVERITY_ERROR;
            case ABORT:
                return SEVERITY_FATAL;
            default:
                return null;
        }
    }
}
