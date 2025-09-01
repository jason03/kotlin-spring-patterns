package net.zeotrope.patterns.builder.service

import net.zeotrope.patterns.builder.model.Address
import net.zeotrope.patterns.builder.model.CustomerAccount
import net.zeotrope.patterns.builder.model.User
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.util.UUID
import kotlin.test.assertEquals

@ActiveProfiles("test")
@AutoConfiguration
@SpringBootTest
class CustomerAccountBuilderServiceTest(
    @Autowired
    private val service: CustomerAccountBuilderService
) {
    @Test
    fun `should build a CustomerAccount instance`() {
        val id = UUID.randomUUID()
        val expectedUser = User(id, "John", "Doe", "john.doe@xxx.xx.xx")
        val expectedAddress = Address("Street line one", "Street line two", "City", "County", "PostCode", "Country")

        val actualAccount = service.buildCustomerAccount(id)

        assertAll(
            { assertEquals(expectedUser, actualAccount.user) },
            { assertEquals(expectedAddress, actualAccount.address) },
            { assertEquals(3, actualAccount.history.orders.size) },
            { assertTrue(actualAccount is CustomerAccount) }
        )
    }
}
