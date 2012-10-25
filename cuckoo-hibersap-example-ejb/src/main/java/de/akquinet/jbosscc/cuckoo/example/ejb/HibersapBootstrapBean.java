package de.akquinet.jbosscc.cuckoo.example.ejb;

import org.hibersap.configuration.AnnotationConfiguration;
import org.hibersap.session.SessionManager;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Startup
public class HibersapBootstrapBean
{
    public static final String JNDI_NAME = "java:jboss/eis/hibersap/NSP";

    private static final Logger LOG = Logger.getLogger( HibersapBootstrapBean.class.getName() );

    @PostConstruct
    public void rebindSessionManager()
    {
        SessionManager sessionManager = new AnnotationConfiguration().buildSessionManager();

        LOG.info( "Binding Hibersap SessionManager '" + sessionManager.getConfig().getName()
                + "' to JNDI name '" + JNDI_NAME + "'" );

        try
        {
            Context ctx = new InitialContext();
            ctx.rebind( JNDI_NAME, sessionManager );
        }
        catch ( NamingException e )
        {
            throw new RuntimeException( "Failed binding Hibersap SessionManager to JNDI name [" + JNDI_NAME + "]", e );
        }
    }

    @PreDestroy
    public void unbindSessionManager()
    {
        LOG.info( "Unbinding Hibersap SessionManager from JNDI name '" + JNDI_NAME + "'" );

        try
        {
            Context ctx = new InitialContext();
            ctx.unbind( JNDI_NAME );
        }
        catch ( NamingException e )
        {
            LOG.log( Level.WARNING,
                    "Failed to unbind Hibersap SessionManager binding for JNDI name [" + JNDI_NAME + "]", e );
        }
    }
}
