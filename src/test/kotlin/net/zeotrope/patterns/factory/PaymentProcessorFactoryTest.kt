package net.zeotrope.patterns.factory

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.stream.Stream

@ActiveProfiles("test")
@AutoConfiguration
@SpringBootTest
class PaymentProcessorFactoryTest(
    @Autowired
    private val factory: PaymentProcessorFactory
) {
    companion object {
        @JvmStatic
        fun factoryTest(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    PaymentType.BankTransfer,
                    BigDecimal.valueOf(100.00).setScale(2, RoundingMode.HALF_UP),
                    PaymentResponse(PaymentStatus.SUCCESS, "Bank transfer payment was successful for amount: 100.00")
                ),
                Arguments.of(
                    PaymentType.Cash,
                    BigDecimal.valueOf(65.95).setScale(2, RoundingMode.HALF_UP),
                    PaymentResponse(PaymentStatus.SUCCESS, "Cash payment was successful for amount: 65.95")
                ),
                Arguments.of(
                    PaymentType.CreditCard,
                    BigDecimal.valueOf(1234.6).setScale(2, RoundingMode.HALF_UP),
                    PaymentResponse(PaymentStatus.SUCCESS, "Credit card payment was successful for amount: 1234.60")
                ),
                Arguments.of(
                    PaymentType.OnlineService,
                    BigDecimal.valueOf(99.5).setScale(2, RoundingMode.HALF_UP),
                    PaymentResponse(PaymentStatus.SUCCESS, "Online service payment was successful for amount: 99.50")
                )
            )
    }

    @ParameterizedTest(name = "should return correct payment processor for type: {0}")
    @MethodSource("factoryTest")
    fun `should test factory`(paymentType: PaymentType, amount: BigDecimal, expectedResult: PaymentResponse) {
        val processor = factory.getPaymentProcessor(paymentType)

        val actualResult = processor.process(amount)

        assertEquals(expectedResult, actualResult)
    }
}
