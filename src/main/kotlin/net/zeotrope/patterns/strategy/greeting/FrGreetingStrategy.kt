package net.zeotrope.patterns.strategy.greeting

import net.zeotrope.patterns.common.SupportedCountryCode
import org.springframework.stereotype.Service

@Service
class FrGreetingStrategy : GreetingStrategy {
    override fun greet(): String = "Bonjour de Français."

    override fun supports(countryCode: SupportedCountryCode): Boolean = SupportedCountryCode.FR == countryCode
}
