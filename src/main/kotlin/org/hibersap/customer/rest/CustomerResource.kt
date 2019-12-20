package org.hibersap.customer.rest

import org.hibersap.SapException
import org.hibersap.customer.model.CustomerWithId
import org.hibersap.customer.service.CustomerService
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.InternalServerErrorException
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType.APPLICATION_JSON
import javax.ws.rs.core.Response

@Path("")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@ApplicationScoped
class CustomerResource {

    @Inject
    private lateinit var customerService: CustomerService

    @GET
    @Path("ping")
    fun ping() = Response.ok().build()

    @GET
    @Path("search/{searchPattern}")
    fun findCustomer(@PathParam("searchPattern") searchPattern: String): List<CustomerWithId> {
        try {
            return customerService.search(searchPattern, 100)
        } catch (e: SapException) {
            throw InternalServerErrorException(e.toString())
        }
    }

///*
//    @GET
//    @Path("mock")
//    fun findCustomer2(@PathParam("searchPattern") searchPattern: String): List<CustomerWithId> = listOf(
//            CustomerWithId(
//                    id = "1",
//                    name = "Jane Doe",
//                    street = "Main Street",
//                    region = "Wild West",
//                    postalCode = "1234",
//                    poBox = "98765",
//                    phoneNumber = "+99123456",
//                    formOfAddress = "Mrs",
//                    email = "jane.doe@example.com",
//                    countryKeyIso = "us",
//                    city = "Dawson City"),
//            CustomerWithId(
//                    id = "2",
//                    name = "John Doe",
//                    street = "Park Avenue",
//                    region = "Far East",
//                    postalCode = "4321",
//                    poBox = "56789",
//                    phoneNumber = "+99987655",
//                    formOfAddress = "Mr",
//                    email = "john@doe.com",
//                    countryKeyIso = "us",
//                    city = "Springfiled"))
//*/
}