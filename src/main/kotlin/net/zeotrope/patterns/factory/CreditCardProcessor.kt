package net.zeotrope.patterns.factory

import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component("creditCard")
class CreditCardProcessor : PaymentProcessor {
    override fun process(amount: BigDecimal) = PaymentResponse(PaymentStatus.SUCCESS, "Credit card payment was successful for amount: $amount")
}
