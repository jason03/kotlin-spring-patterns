package net.zeotrope.patterns.factory

import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component("onlineService")
class OnlineServiceProcessor : PaymentProcessor {
    override fun process(amount: BigDecimal) = PaymentResponse(PaymentStatus.SUCCESS, "Online service payment was successful for amount: $amount")
}
