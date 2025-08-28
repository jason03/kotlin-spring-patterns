package net.zeotrope.patterns.strategy.greeting

import net.zeotrope.patterns.common.SupportedCountryCode
import org.springframework.plugin.core.Plugin

interface GreetingStrategy : Plugin<SupportedCountryCode> {
    fun greet(): String
}
