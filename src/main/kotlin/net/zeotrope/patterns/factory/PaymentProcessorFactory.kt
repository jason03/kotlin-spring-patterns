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

    // Alt non-bean approach. Returns new processor instance not wrapped in a bean.
    fun getPaymentProcessor(paymentType: String): PaymentProcessor =
        when (paymentType) {
            "bankTransfer" -> BankTransferProcessor()
            "cash" -> CashProcessor()
            "creditCard" -> CreditCardProcessor()
            "onlineService" -> OnlineServiceProcessor()
            else -> throw IllegalArgumentException("No processor found for type: $paymentType")
        }
}
