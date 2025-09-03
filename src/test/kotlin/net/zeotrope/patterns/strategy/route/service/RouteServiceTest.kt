package net.zeotrope.patterns.strategy.route.service

import net.zeotrope.patterns.strategy.route.model.Location
import net.zeotrope.patterns.strategy.route.model.Route
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@AutoConfiguration
@SpringBootTest
class RouteServiceTest(
    @Autowired
    private val service: RouteService
) {

    @Test
    fun `should throw an exception when the route is not found`() {
        val testLocation = Location(0.0, 0.0)
        assertThrows<IllegalArgumentException> {
            service.getRoute("unknown", testLocation, testLocation)
        }.apply {
            assertEquals("Invalid strategy. Must be one of bus, car, walking", message)
        }
    }

    @CsvSource(
        "bus",
        "car",
        "walking"
    )
    @ParameterizedTest(name = "should return correct route for {0} transportation")
    fun `should return correct route for the specified transportation type`(transportation: String) {
        val testLocation = Location(0.0, 0.0)
        val expectedRoute = Route(listOf(testLocation, testLocation))
        val actualRoute = service.getRoute(transportation, testLocation, testLocation)

        assertEquals(expectedRoute, actualRoute)
    }
}
