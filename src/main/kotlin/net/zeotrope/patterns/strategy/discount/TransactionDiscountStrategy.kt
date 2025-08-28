package net.zeotrope.patterns.strategy.discount

import java.math.BigDecimal

interface TransactionDiscountStrategy {
    fun discountAmount(): BigDecimal
}
