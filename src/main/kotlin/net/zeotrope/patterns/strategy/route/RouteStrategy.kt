package net.zeotrope.patterns.strategy.route

import net.zeotrope.patterns.strategy.route.model.Location
import net.zeotrope.patterns.strategy.route.model.Route

interface RouteStrategy {
    fun key(): String
    fun buildRoute(start: Location, end: Location): Route
}
