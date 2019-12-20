package org.hibersap.customer.service

import org.hibersap.configuration.AnnotationConfiguration
import java.util.logging.Level
import java.util.logging.Logger
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy
import javax.ejb.Singleton
import javax.ejb.Startup
import javax.naming.Context
import javax.naming.InitialContext
import javax.naming.NamingException

const val JNDI_NAME = "java:jboss/eis/hibersap/NSP"

@Singleton
@Startup
class HibersapBootstrapBean {

    @PostConstruct
    fun rebindSessionManager() {
        val sessionManager = AnnotationConfiguration().buildSessionManager()
        LOG.info("Binding Hibersap SessionManager '${sessionManager.config.name}' to JNDI name '$JNDI_NAME'")
        try {
            val ctx: Context = InitialContext()
            ctx.rebind(JNDI_NAME, sessionManager)
        } catch (e: NamingException) {
            throw RuntimeException("Failed binding Hibersap SessionManager to JNDI name [$JNDI_NAME]", e)
        }
    }

    @PreDestroy
    fun unbindSessionManager() {
        LOG.info("Unbinding Hibersap SessionManager from JNDI name [$JNDI_NAME]")
        try {
            val ctx: Context = InitialContext()
            ctx.unbind(JNDI_NAME)
        } catch (e: NamingException) {
            LOG.log(Level.WARNING,
                    "Failed to unbind Hibersap SessionManager binding for JNDI name [$JNDI_NAME]", e)
        }
    }

    companion object {
        private val LOG = Logger.getLogger(HibersapBootstrapBean::class.java.name)
    }
}