package net.zeotrope.patterns.strategy.greeting

import net.zeotrope.patterns.common.SupportedCountryCode
import org.springframework.stereotype.Service

@Service
class UsGreetingStrategy : GreetingStrategy {
    override fun greet(): String = "Hello from the United States."

    override fun supports(countryCode: SupportedCountryCode): Boolean = SupportedCountryCode.US == countryCode
}
