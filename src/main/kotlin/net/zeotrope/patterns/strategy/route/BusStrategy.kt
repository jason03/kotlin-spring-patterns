package net.zeotrope.patterns.strategy.route

import net.zeotrope.patterns.strategy.route.model.Location
import net.zeotrope.patterns.strategy.route.model.Route
import org.springframework.stereotype.Component

@Component
class BusStrategy : RouteStrategy {
    override fun key() = "bus"

    override fun buildRoute(start: Location, end: Location) = Route(listOf(start, end))
}
