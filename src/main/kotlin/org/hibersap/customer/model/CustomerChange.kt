package org.hibersap.customer.model

import org.hibersap.annotations.*

@Bapi("BAPI_FLCUST_CHANGE")
@ThrowExceptionOnError(returnStructure = "TABLE/RETURN")
data class CustomerChange(
        @Import @Parameter("CUSTOMERNUMBER")
        private val customerId: String,

        @Import @Parameter(value = "CUSTOMER_DATA", type = ParameterType.STRUCTURE)
        private val customerData: Customer,

        @Import @Parameter(value = "CUSTOMER_DATA_X", type = ParameterType.STRUCTURE)
        private val fieldsToChange: Customer = Customer(),

        @Table
        @Parameter("RETURN")
        val returnMessages: List<ReturnMessage> = listOf()
) {
    init {
        fieldsToChange.name = CHANGE
        fieldsToChange.city = CHANGE
        fieldsToChange.countryKeyIso = CHANGE
        fieldsToChange.email = CHANGE
        fieldsToChange.formOfAddress = CHANGE
        fieldsToChange.phoneNumber = CHANGE
        fieldsToChange.poBox = CHANGE
        fieldsToChange.postalCode = CHANGE
        fieldsToChange.region = CHANGE
        fieldsToChange.street = CHANGE
    }

    companion object {
        private const val CHANGE = "X"
    }
}