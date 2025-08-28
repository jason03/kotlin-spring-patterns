package net.zeotrope.patterns.strategy.greeting

import net.zeotrope.patterns.common.SupportedCountryCode
import net.zeotrope.patterns.strategy.greeting.service.GreetingService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import kotlin.test.assertTrue

@ActiveProfiles("test")
@AutoConfiguration
@SpringBootTest
class GreetingStrategyTest(
    @Autowired val greetingService: GreetingService
) {
    @CsvSource(
        "DE, Hallo aus Deutschland.",
        "ES, Hola desde España.",
        "FR, Bonjour de Français.",
        "IT, Ciao dall'Italia.",
        "UK, Hello from the United Kingdom.",
        "US, Hello from the United States."
    )
    @ParameterizedTest(name = "should return greeting: {1} for country: {0}")
    fun `should return correct greeting for the country code`(countryCode: SupportedCountryCode, expectedGreeting: String) {
        assertEquals(expectedGreeting, greetingService.greet(countryCode))
    }

    @Test
    fun `should throw an exception when an unsupported country code value is applied`() {
        assertThrows<Exception> {
            greetingService.greet(SupportedCountryCode.valueOf("DK"))
        }.apply {
            assertTrue(message?.let { it.contains("No enum constant net.zeotrope.patterns.common.SupportedCountryCode.DK") } ?: false)
        }
    }
}
