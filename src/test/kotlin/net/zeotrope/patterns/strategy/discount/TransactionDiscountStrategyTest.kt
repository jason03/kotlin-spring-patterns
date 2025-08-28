package net.zeotrope.patterns.strategy.discount

import net.zeotrope.patterns.common.AccountType
import net.zeotrope.patterns.strategy.discount.service.TransactionDiscountService
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import kotlin.test.assertEquals

@ActiveProfiles("test")
@AutoConfiguration
@SpringBootTest
class TransactionDiscountStrategyTest(
    @Autowired val service: TransactionDiscountService
) {
    @CsvSource(
        "ISA, 0.020",
        "SAVINGS, 0.025",
        "ETF, 0.015"
    )
    @ParameterizedTest(name = "should return discount amount: {1} for account type: {0}")
    fun `should return correct discount amount for account type`(accountType: AccountType, expectedDiscount: BigDecimal) {
        val actualDiscount = service.discountForAccountType(accountType)

        assertEquals(expectedDiscount, actualDiscount)
    }
}
