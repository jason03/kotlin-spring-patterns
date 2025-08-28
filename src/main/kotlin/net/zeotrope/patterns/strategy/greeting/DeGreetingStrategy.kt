package net.zeotrope.patterns.strategy.greeting

import net.zeotrope.patterns.common.SupportedCountryCode
import org.springframework.stereotype.Service

@Service
class DeGreetingStrategy : GreetingStrategy {
    override fun greet(): String = "Hallo aus Deutschland."

    override fun supports(countryCode: SupportedCountryCode): Boolean = SupportedCountryCode.DE == countryCode
}
