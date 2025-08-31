package net.zeotrope.patterns.factory

import org.springframework.stereotype.Component

@Component
class PaymentProcessorFactory(val processors: Map<String, PaymentProcessor>) {

    fun getPaymentProcessor(paymentType: PaymentType): PaymentProcessor =
        when (paymentType) {
            PaymentType.BankTransfer,
            PaymentType.Cash,
            PaymentType.CreditCard,
            PaymentType.OnlineService -> processors[paymentType.type] ?: throw IllegalArgumentException("No processor found for type: $paymentType")
        }
}
