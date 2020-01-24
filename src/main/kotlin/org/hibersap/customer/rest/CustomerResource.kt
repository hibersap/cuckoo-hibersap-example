package org.hibersap.customer.rest

import org.hibersap.SapException
import org.hibersap.customer.model.Customer
import org.hibersap.customer.model.CustomerWithId
import org.hibersap.customer.service.CustomerService
import java.util.logging.Logger
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType.APPLICATION_JSON
import javax.ws.rs.core.Response
import kotlin.math.min

@Path("customer")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@ApplicationScoped
class CustomerResource {

    @Inject
    private lateinit var customerService: CustomerService

    private val maxSearchResult = 1_000
    private val defaultSearchResult = 10

    @GET
    @Path("search")
    fun findCustomer(@QueryParam("pattern") searchPattern: String?, @QueryParam("max") rows: Int): List<CustomerWithId> {
        if (searchPattern == null) throw BadRequestException("Query parameter 'pattern' is missing")

        val maxRows = if (rows <= 0) defaultSearchResult else min(rows, maxSearchResult) // 0 means all rows in BAPI
        LOGGER.info("searching for customers with pattern '$searchPattern', returning a maximum of $maxRows costumers")

        try {
            return customerService.find(searchPattern, maxRows).sortedBy { it.name }
        } catch (e: SapException) {
            throw InternalServerErrorException(e.toString())
        }
    }

    @PUT
    @Path("{id}")
    fun updateCustomer(@PathParam("id") id: String, customer: Customer?): Response {
        if (customer == null) throw BadRequestException("Customer data is missing")

        LOGGER.info("changing customer with id '$id': $customer")

        try {
            customerService.update(id, customer)
            return Response.noContent().build()
        } catch (e: SapException) {
            throw InternalServerErrorException(e.toString())
        }
    }

    companion object {
        private val LOGGER = Logger.getLogger(CustomerResource::class.java.name)
    }
}