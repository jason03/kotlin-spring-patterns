package net.zeotrope.patterns.factory

sealed class PaymentType(val type: String) {
    object CreditCard : PaymentType("creditCard")
    object Cash : PaymentType("cash")
    object OnlineService : PaymentType("onlineService")
    object BankTransfer : PaymentType("bankTransfer")
}
