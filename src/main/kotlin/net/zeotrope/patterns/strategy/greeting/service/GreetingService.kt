package net.zeotrope.patterns.strategy.greeting.service

import net.zeotrope.patterns.common.SupportedCountryCode
import net.zeotrope.patterns.strategy.greeting.GreetingStrategy
import org.springframework.plugin.core.PluginRegistry
import org.springframework.stereotype.Service

@Service
class GreetingService(val greetingStrategy: PluginRegistry<GreetingStrategy, SupportedCountryCode>) {
    fun greet(countryCode: SupportedCountryCode): String = getGreetingForCountry(countryCode).greet()

    private fun getGreetingForCountry(countryCode: SupportedCountryCode): GreetingStrategy =
        greetingStrategy.getPluginFor(countryCode).orElseThrow { RuntimeException("No strategy found for Country Code: $countryCode") }
}
