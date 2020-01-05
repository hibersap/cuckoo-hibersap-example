package org.hibersap.customer.service

import org.hibersap.configuration.AnnotationConfiguration
import org.hibersap.ejb.util.JndiUtil
import java.util.logging.Logger
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy
import javax.ejb.Singleton
import javax.ejb.Startup

const val JNDI_NAME = "java:jboss/eis/hibersap/NSP"

@Singleton
@Startup
class HibersapBootstrapBean {

    @PostConstruct
    fun rebindSessionManager() {
        val sessionManager = AnnotationConfiguration("NSP").buildSessionManager()
        JndiUtil.rebindSessionManager(sessionManager, JNDI_NAME);
    }

    @PreDestroy
    fun unbindSessionManager() {
        JndiUtil.unbindSessionManager(JNDI_NAME)
    }

    companion object {
        private val LOG = Logger.getLogger(HibersapBootstrapBean::class.java.name)
    }
}