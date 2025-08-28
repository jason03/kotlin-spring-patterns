package net.zeotrope.patterns.strategy.discount

import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.math.RoundingMode

@Component("isaDiscount")
class IsaDiscountStrategy : TransactionDiscountStrategy {
    override fun discountAmount(): BigDecimal = BigDecimal.valueOf(0.020).setScale(3, RoundingMode.HALF_UP)
}
