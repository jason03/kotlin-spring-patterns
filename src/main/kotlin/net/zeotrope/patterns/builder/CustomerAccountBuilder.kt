package net.zeotrope.patterns.builder

import net.zeotrope.patterns.builder.model.Address
import net.zeotrope.patterns.builder.model.CustomerAccount
import net.zeotrope.patterns.builder.model.Order
import net.zeotrope.patterns.builder.model.OrderHistory
import net.zeotrope.patterns.builder.model.User
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.util.UUID

@Scope("prototype")
@Component
class CustomerAccountBuilder {
    private lateinit var user: User
    private lateinit var address: Address
    private lateinit var orderHistory: OrderHistory

    fun withUser(id: UUID) = apply { user = User(id, "John", "Doe", "john.doe@xxx.xx.xx") }

    fun withAddress() = apply { address = Address("Street line one", "Street line two", "City", "County", "PostCode", "Country") }

    fun withOrderHistory() = apply { orderHistory = OrderHistory(listOf(Order(UUID.randomUUID()), Order(UUID.randomUUID()), Order(UUID.randomUUID()))) }

    fun build(): CustomerAccount {
        when {
            (!::user.isInitialized) ||
                (!::address.isInitialized) ||
                (!::orderHistory.isInitialized) -> throw IllegalStateException("CustomerAccount is not initialized")
        }
        return CustomerAccount(user, address, orderHistory)
    }
}
