package org.hibersap.customer.model

import org.hibersap.annotations.Bapi
import org.hibersap.annotations.Import
import org.hibersap.annotations.Parameter
import org.hibersap.annotations.ParameterType
import org.hibersap.annotations.Table

@Bapi("BAPI_FLCUST_CHANGE")
class CustomerChange(
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