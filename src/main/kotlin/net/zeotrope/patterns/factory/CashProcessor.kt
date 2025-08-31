package net.zeotrope.patterns.factory

import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component("cash")
class CashProcessor : PaymentProcessor {
    override fun process(amount: BigDecimal) = PaymentResponse(PaymentStatus.SUCCESS, "Cash payment was successful for amount: $amount")
}
