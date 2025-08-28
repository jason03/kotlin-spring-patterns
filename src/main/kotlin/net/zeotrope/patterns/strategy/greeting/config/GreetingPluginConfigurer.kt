package net.zeotrope.patterns.strategy.greeting.config

import net.zeotrope.patterns.strategy.greeting.GreetingStrategy
import org.springframework.context.annotation.Configuration
import org.springframework.plugin.core.config.EnablePluginRegistries

@EnablePluginRegistries(
    GreetingStrategy::class
)
@Configuration
class GreetingPluginConfigurer
