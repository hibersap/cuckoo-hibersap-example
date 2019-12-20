package org.hibersap.customer.model

import org.hibersap.annotations.BapiStructure
import org.hibersap.annotations.Parameter

@BapiStructure
class CustomerWithId : Customer() {
    @Parameter("CUSTOMERID")
    val id: String = ""

    override fun toString(): String {
        return "CustomerWithId(id='$id')"
    }
}