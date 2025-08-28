package net.zeotrope.patterns.strategy.greeting

import net.zeotrope.patterns.common.SupportedCountryCode
import org.springframework.stereotype.Service

@Service
class UkGreetingStrategy : GreetingStrategy {
    override fun greet(): String = "Hello from the United Kingdom."

    override fun supports(countryCode: SupportedCountryCode): Boolean = SupportedCountryCode.UK == countryCode
}
