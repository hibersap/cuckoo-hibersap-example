package org.hibersap.customer.model

import org.hibersap.annotations.Bapi
import org.hibersap.annotations.Import
import org.hibersap.annotations.Parameter
import org.hibersap.annotations.Table
import org.hibersap.annotations.ThrowExceptionOnError

@Bapi("BAPI_FLCUST_GETLIST")
@ThrowExceptionOnError(returnStructure = "TABLE/RETURN")
data class CustomerSearch(

        @Parameter("CUSTOMER_NAME")
        @Import
        private var nameSearchPattern: String,

        @Parameter("MAX_ROWS")
        @Import
        private var maxRows: Int,

        @Table
        @Parameter("RETURN")
        var returnMessages: List<ReturnMessage> = listOf(),

        @Table
        @Parameter("CUSTOMER_LIST")
        var customers: List<CustomerWithId> = listOf()
)