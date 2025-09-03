package net.zeotrope.patterns.strategy.route.service

import net.zeotrope.patterns.strategy.route.RouteStrategy
import net.zeotrope.patterns.strategy.route.model.Location
import org.springframework.stereotype.Service

@Service
class RouteService(strategies: List<RouteStrategy>) {
    private val strategyMap = strategies.associateBy { it.key() }

    private fun getRouteStrategy(key: String) =
        strategyMap[key] ?: throw IllegalArgumentException("Invalid strategy. Must be one of ${strategyMap.keys.joinToString()}")

    fun getRoute(transportType: String, start: Location, end: Location) = getRouteStrategy(transportType).buildRoute(start, end)
}
