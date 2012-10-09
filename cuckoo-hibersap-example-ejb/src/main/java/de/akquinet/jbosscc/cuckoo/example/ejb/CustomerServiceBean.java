package de.akquinet.jbosscc.cuckoo.example.ejb;

import de.akquinet.jbosscc.cuckoo.example.model.Customer;
import de.akquinet.jbosscc.cuckoo.example.model.CustomerChange;
import de.akquinet.jbosscc.cuckoo.example.model.CustomerSearch;
import de.akquinet.jbosscc.cuckoo.example.model.ReturnMessage;
import org.hibersap.ejb.interceptor.HibersapSession;
import org.hibersap.ejb.interceptor.HibersapSessionInterceptor;
import org.hibersap.session.Session;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;
import java.util.logging.Logger;

@Stateless
@Interceptors( HibersapSessionInterceptor.class )
public class CustomerServiceBean implements CustomerService
{
    private static final Logger LOGGER = Logger.getLogger( CustomerServiceBean.class.getName() );

    @HibersapSession( HibersapBootstrapBean.JNDI_NAME )
    private Session session;

    public CustomerSearch search( String nameSearchPattern, int maxRows )
    {
        CustomerSearch customerSearch = new CustomerSearch( nameSearchPattern, maxRows );
        session.execute( customerSearch );
        return customerSearch;
    }

    public List<ReturnMessage> store( String customerId, Customer customer )
    {
        LOGGER.info( "Storing customer " + customer );

        CustomerChange customerChange = new CustomerChange( customerId, customer );
        session.execute( customerChange );
        return customerChange.getReturnMessages();
    }
}
