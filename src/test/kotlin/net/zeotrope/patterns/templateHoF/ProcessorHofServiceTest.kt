package net.zeotrope.patterns.templateHoF

import net.zeotrope.patterns.common.DataType
import net.zeotrope.patterns.templateHoF.service.ProcessorHofService
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import kotlin.test.assertEquals

@ActiveProfiles("test")
@AutoConfiguration
@SpringBootTest
class ProcessorHofServiceTest(
    @Autowired
    private val processorHofService: ProcessorHofService
) {

    @CsvSource(
        "CSV,'Loading CSV data..., Analysing CSV data..., Saving CSV data...'",
        "JSON,'Loading JSON data..., Analysing JSON data..., Saving JSON data...'"
    )
    @ParameterizedTest(name = "should process data for {0} format")
    fun `should process data for the specified format`(type: DataType, expectedResult: String) {
        val actualResult = processorHofService.process(type)

        assertEquals(expectedResult, actualResult)
    }
}
