package net.zeotrope.patterns.builder.service

import net.zeotrope.patterns.builder.CustomerAccountBuilder
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CustomerAccountBuilderService(private val customerAccountBuilder: CustomerAccountBuilder) {
    fun buildCustomerAccount(id: UUID) =
        customerAccountBuilder
            .withUser(id)
            .withAddress()
            .withOrderHistory()
            .build()
}
