package net.zeotrope.patterns.factory

import java.math.BigDecimal

interface PaymentProcessor {
    fun process(amount: BigDecimal): PaymentResponse
}

data class PaymentResponse(val status: PaymentStatus, val message: String)

enum class PaymentStatus {
    SUCCESS,
    FAILURE
}
