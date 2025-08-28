package net.zeotrope.patterns.strategy.greeting

import net.zeotrope.patterns.common.SupportedCountryCode
import org.springframework.stereotype.Service

@Service
class ItGreetingStrategy : GreetingStrategy {
    override fun greet(): String = "Ciao dall'Italia."

    override fun supports(countryCode: SupportedCountryCode): Boolean = SupportedCountryCode.IT == countryCode
}
