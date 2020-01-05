package org.hibersap.customer.model

import org.hibersap.annotations.BapiStructure
import org.hibersap.annotations.Parameter
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@BapiStructure
data class CustomerWithId(
        @Parameter("CUSTOMERID") val id: String = "",
        @Parameter("CUSTNAME") var name: String = "",
        @Parameter("FORM") var formOfAddress: String = "",
        @Parameter("STREET") var street: String = "",
        @Parameter("POBOX") var poBox: String = "",
        @Parameter("POSTCODE") var postalCode: String = "",
        @Parameter("CITY") var city: String = "",
        @Parameter("COUNTR_ISO") @field:NotNull @field:Size(min = 2, max = 2) var countryKeyIso: String = "",
        @Parameter("REGION") var region: String = "",
        @Parameter("PHONE") var phoneNumber: String = "",
        @Parameter("EMAIL") var email: String = ""
)