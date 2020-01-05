package org.hibersap.customer.service

import org.hibersap.customer.model.Customer
import org.hibersap.customer.model.CustomerChange
import org.hibersap.customer.model.CustomerSearch
import org.hibersap.customer.model.CustomerWithId
import org.hibersap.customer.model.ReturnMessage
import org.hibersap.ejb.interceptor.HibersapSession
import org.hibersap.ejb.interceptor.HibersapSessionInterceptor
import org.hibersap.session.Session
import java.util.logging.Logger
import javax.ejb.Stateless
import javax.interceptor.Interceptors

@Stateless
@Interceptors(HibersapSessionInterceptor::class)
class CustomerService {

    @HibersapSession(JNDI_NAME)
    private lateinit var session: Session

    fun find(nameSearchPattern: String, maxRows: Int): List<CustomerWithId> {
        val customerSearch = CustomerSearch(nameSearchPattern, maxRows)
        session.execute(customerSearch)
        return customerSearch.customers
    }

    fun update(customerId: String, customer: Customer) {
        LOGGER.info("Updating customer $customer")
        val customerChange = CustomerChange(customerId = customerId, customerData = customer)
        session.execute(customerChange)
    }

    companion object {
        private val LOGGER = Logger.getLogger(CustomerService::class.java.name)
    }
}