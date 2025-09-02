package net.zeotrope.patterns.template

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@AutoConfiguration
@SpringBootTest
class ProcessorTemplateServiceTest(
    @Autowired
    private val processorTemplateService: ProcessorTemplateService
) {

    @CsvSource(
        "CSV,'Loading CSV data..., Processing CSV data..., Saving data to database.'",
        "JSON,'Loading JSON data..., Processing JSON data..., Saving data to database.'"
    )
    @ParameterizedTest(name = "ProcessorTemplateService should process data for {0} format")
    fun `shoukd process data`(dataType: DataType, expectedResult: String) {
        val actual = processorTemplateService.processData(dataType)

        assertEquals(expectedResult, actual)
    }
}
