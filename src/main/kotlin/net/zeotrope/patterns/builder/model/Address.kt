package net.zeotrope.patterns.builder.model

data class Address(
    val street1: String,
    val street2: String,
    val city: String,
    val county: String,
    val postCode: String,
    val country: String
)
