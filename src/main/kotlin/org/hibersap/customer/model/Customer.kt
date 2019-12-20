package org.hibersap.customer.model

import org.hibersap.annotations.BapiStructure
import org.hibersap.annotations.Parameter
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@BapiStructure
open class Customer {
    @Parameter("CUSTNAME")
    var name: String = ""

    @Parameter("FORM")
    var formOfAddress: String = ""

    @Parameter("STREET")
    var street: String = ""

    @Parameter("POBOX")
    var poBox: String = ""

    @Parameter("POSTCODE")
    var postalCode: String = ""

    @Parameter("CITY")
    var city: String = ""

    @Parameter("COUNTR_ISO")
    @NotNull
    @Size(min = 2, max = 2)
    var countryKeyIso: String = ""

    @Parameter("REGION")
    var region: String = ""

    @Parameter("PHONE")
    var phoneNumber: String = ""

    @Parameter("EMAIL")
    var email: String = ""

    override fun toString(): String {
        return "Customer(name=$name, formOfAddress=$formOfAddress, street=$street, poBox=$poBox, postalCode=$postalCode, city=$city, countryKeyIso=$countryKeyIso, region=$region, phoneNumber=$phoneNumber, email=$email)"
    }
}