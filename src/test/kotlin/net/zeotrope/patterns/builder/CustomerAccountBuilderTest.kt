package net.zeotrope.patterns.builder

import net.zeotrope.patterns.builder.model.Address
import net.zeotrope.patterns.builder.model.CustomerAccount
import net.zeotrope.patterns.builder.model.User
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.util.UUID
import kotlin.test.assertEquals

@ActiveProfiles("test")
@AutoConfiguration
@SpringBootTest
class CustomerAccountBuilderTest(
    @Autowired
    private val builder: CustomerAccountBuilder
) {
    @Test
    fun `should build a CustomerAccount instance`() {
        val id = UUID.randomUUID()
        val expectedUser = User(id, "John", "Doe", "john.doe@xxx.xx.xx")
        val expectedAddress = Address("Street line one", "Street line two", "City", "County", "PostCode", "Country")

        val account =
            builder
                .withUser(id)
                .withAddress()
                .withOrderHistory()
                .build()

        assertAll(
            { assertEquals(expectedUser, account.user) },
            { assertEquals(expectedAddress, account.address) },
            { assertEquals(3, account.history.orders.size) },
            { assertTrue(account is CustomerAccount) }
        )
    }

    @CsvSource(
        "user",
        "address",
        "orderHistory"
    )
    @ParameterizedTest(name = "CustomerAccount built with initialised {0} component")
    fun `should throw an exception when the builder is not initialized`(component: String) {
        assertThrows<IllegalStateException> {
            when (component) {
                "user" -> builder.withUser(UUID.randomUUID())
                "address" -> builder.withAddress()
                "orderHistory" -> builder.withOrderHistory()
            }
            builder.build()
        }.apply {
            assertTrue(message?.contains("CustomerAccount is not initialized") ?: false)
        }
    }
}
