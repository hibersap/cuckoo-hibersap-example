package org.hibersap.customer.conversion

import org.hibersap.conversion.Converter
import org.hibersap.customer.model.Severity
import org.hibersap.customer.model.Severity.Companion.fromSapType

class SeverityConverter : Converter<Severity, String> {

    override fun convertToJava(sapValue: String): Severity {
        return fromSapType(sapValue[0])
    }

    override fun convertToSap(javaValue: Severity): String {
        return javaValue.sapType.toString()
    }
}