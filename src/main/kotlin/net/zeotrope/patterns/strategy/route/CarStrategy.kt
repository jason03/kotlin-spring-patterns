package net.zeotrope.patterns.strategy.route

import net.zeotrope.patterns.strategy.route.model.Location
import net.zeotrope.patterns.strategy.route.model.Route
import org.springframework.stereotype.Component

@Component
class CarStrategy : RouteStrategy {
    override fun key() = "car"

    override fun buildRoute(start: Location, end: Location) = Route(listOf(start, end))
}
