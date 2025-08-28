package net.zeotrope.patterns

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StrategyPatternApplication

fun main(args: Array<String>) {
    runApplication<StrategyPatternApplication>(*args)
}
