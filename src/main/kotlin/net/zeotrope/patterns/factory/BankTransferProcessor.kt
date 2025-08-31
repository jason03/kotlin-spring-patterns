package net.zeotrope.patterns.factory

import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component("bankTransfer")
class BankTransferProcessor : PaymentProcessor {

    override fun process(amount: BigDecimal) = PaymentResponse(PaymentStatus.SUCCESS, "Bank transfer payment was successful for amount: $amount")
}
