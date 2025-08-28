package net.zeotrope.patterns.strategy.greeting

import net.zeotrope.patterns.common.SupportedCountryCode
import org.springframework.stereotype.Service

@Service
class EsGreetingStrategy : GreetingStrategy {
    override fun greet(): String = "Hola desde España."

    override fun supports(countryCode: SupportedCountryCode): Boolean = SupportedCountryCode.ES == countryCode
}
