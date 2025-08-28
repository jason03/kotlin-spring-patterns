package net.zeotrope.patterns.common

enum class AccountType(val discountStrategy: String) {
    ETF("etfDiscount"),
    ISA("isaDiscount"),
    SAVINGS("savingsDiscount")
}
