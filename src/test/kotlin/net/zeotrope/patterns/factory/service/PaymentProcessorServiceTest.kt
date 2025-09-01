package net.zeotrope.patterns.factory.service

import net.zeotrope.patterns.factory.BankTransferProcessor
import net.zeotrope.patterns.factory.CreditCardProcessor
import net.zeotrope.patterns.factory.OnlineServiceProcessor
import net.zeotrope.patterns.factory.PaymentResponse
import net.zeotrope.patterns.factory.PaymentStatus
import net.zeotrope.patterns.factory.PaymentType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.mockito.Mock
import org.mockito.Mockito.any
import org.mockito.Mockito.anyString
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.Spy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean
import java.math.BigDecimal
import kotlin.test.assertEquals

@ActiveProfiles("test")
@AutoConfiguration
@SpringBootTest
class PaymentProcessorServiceTest(
    @Autowired
    private val service: PaymentProcessorService
) {

    @MockitoBean
    private lateinit var creditCardProcessor: CreditCardProcessor

    @MockitoSpyBean
    private lateinit var serviceSpy: PaymentProcessorService

    @Mock
    private lateinit var onlineServiceProcessor: OnlineServiceProcessor

    @Test
    fun `should verify that process payment is delegated to the correct processor`() {
        `when`(
            creditCardProcessor.process(
                BigDecimal.valueOf(100.00)
            )
        ).thenReturn(PaymentResponse(PaymentStatus.SUCCESS, "Payment was successful."))

        val response = service.processPayment(BigDecimal.valueOf(100.00), PaymentType.CreditCard)

        assertAll(
            { assertEquals(PaymentStatus.SUCCESS, response.status) },
            { assertEquals("Payment was successful.", response.message) }
        )
        verify(creditCardProcessor).process(BigDecimal.valueOf(100.00))
    }

    @Test
    fun `should verify that process payment is delegated to the correct processor by string type`() {
        val paymentValue = BigDecimal.valueOf(10.75)

        `when`(
            onlineServiceProcessor.process(paymentValue)
        ).thenReturn(PaymentResponse(PaymentStatus.SUCCESS, "Mock payment was successful."))

        `when`(
            serviceSpy.processPayment(paymentValue, "onlineService")
        ).then { call -> onlineServiceProcessor.process(call.arguments[0] as BigDecimal) }

        val response = serviceSpy.processPayment(paymentValue, "onlineService")

        assertAll(
            { assertEquals(PaymentStatus.SUCCESS, response.status) },
            { assertEquals("Mock payment was successful.", response.message) }
        )
        verify(onlineServiceProcessor).process(paymentValue)
    }

    @Test
    fun `should throw exception when payment type is not supported`() {
        assertThrows<IllegalArgumentException> {
            service.processPayment(BigDecimal.valueOf(100.00), "invalid")
        }
    }
}
