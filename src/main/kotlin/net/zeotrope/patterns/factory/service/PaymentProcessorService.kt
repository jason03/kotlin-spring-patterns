package net.zeotrope.patterns.factory.service

import net.zeotrope.patterns.factory.PaymentProcessorFactory
import net.zeotrope.patterns.factory.PaymentType
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class PaymentProcessorService(private val factory: PaymentProcessorFactory) {

    fun processPayment(amount: BigDecimal, paymentType: PaymentType) = factory.getPaymentProcessor(paymentType).process(amount)

    fun processPayment(amount: BigDecimal, paymentType: String) = factory.getPaymentProcessor(paymentType).process(amount)
}
