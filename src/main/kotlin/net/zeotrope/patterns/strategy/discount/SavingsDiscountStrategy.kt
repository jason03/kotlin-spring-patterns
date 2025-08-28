package net.zeotrope.patterns.strategy.discount

import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.math.RoundingMode

@Component("savingsDiscount")
class SavingsDiscountStrategy : TransactionDiscountStrategy {
    override fun discountAmount(): BigDecimal = BigDecimal.valueOf(0.025).setScale(3, RoundingMode.HALF_UP)
}
