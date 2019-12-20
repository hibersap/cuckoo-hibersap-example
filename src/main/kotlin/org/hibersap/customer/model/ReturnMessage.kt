package org.hibersap.customer.model

import org.hibersap.annotations.BapiStructure
import org.hibersap.annotations.Convert
import org.hibersap.annotations.Parameter
import org.hibersap.customer.conversion.SeverityConverter

@BapiStructure
class ReturnMessage {

    @Parameter("MESSAGE")
    var message: String = ""

    @Parameter("TYPE")
    @Convert(converter = SeverityConverter::class)
    var severity: String = ""

}
