package org.hibersap.customer.model

enum class Severity(val sapType: Char) {
    INFO('I'), SUCCESS('S'), WARNING('W'), ERROR('E'), ABORT('A'), OTHER(' ');

    companion object {
        fun fromSapType(sapType: Char): Severity {
            for (severity in values()) {
                if (severity.sapType == sapType) {
                    return severity
                }
            }
            return OTHER
        }
    }
}