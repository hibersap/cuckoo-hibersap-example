package org.hibersap.customer.conversion

import org.assertj.core.api.Assertions.assertThat
import org.hibersap.customer.model.Severity
import org.junit.Test

class SeverityConverterTest {
    private val severityConverter = SeverityConverter()

    @Test
    fun `converts SAP code E to Severity Error`() {
        val sapError = "E"

        val result = severityConverter.convertToJava(sapError)

        assertThat(result).isEqualTo(Severity.ERROR)
    }

    @Test
    fun `converts unknown SAP code to Severity Other`() {
        val sapUnknown = "UNKNOWN"

        val result = severityConverter.convertToJava(sapUnknown)

        assertThat(result).isEqualTo(Severity.OTHER)
    }

    @Test
    fun `converts Severity Info to SAP code I`() {
        val severity = Severity.INFO

        val result = severityConverter.convertToSap(severity)

        assertThat(result).isEqualTo("I")
    }
}