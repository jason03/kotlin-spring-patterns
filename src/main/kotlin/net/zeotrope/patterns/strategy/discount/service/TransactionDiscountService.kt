package net.zeotrope.patterns.strategy.discount.service

import net.zeotrope.patterns.common.AccountType
import net.zeotrope.patterns.strategy.discount.TransactionDiscountStrategy
import org.springframework.stereotype.Service

@Service
class TransactionDiscountService(val strategies: Map<String, TransactionDiscountStrategy>) {
    fun discountForAccountType(accountType: AccountType) =
        strategies[accountType.discountStrategy]?.let { it.discountAmount() } ?: throw IllegalArgumentException("Invalid account type")
}
