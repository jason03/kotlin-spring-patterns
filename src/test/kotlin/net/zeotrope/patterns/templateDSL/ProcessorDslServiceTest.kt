package net.zeotrope.patterns.templateDSL

import net.zeotrope.patterns.common.DataType
import net.zeotrope.patterns.templateDSL.service.ProcessorDslService
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
class ProcessorDslServiceTest(
    @Autowired
    private val processorDslService: ProcessorDslService
) {

    @CsvSource(
        "CSV,'Loading CSV data..., Analysing CSV data..., Saving CSV data...'",
        "JSON,'Loading JSON data..., Analysing JSON data..., Saving JSON data...'"
    )
    @ParameterizedTest(name = "should process data for {0} format")
    fun `should process data for the specified format`(type: DataType, expectedResult: String) {
        val actualResult = processorDslService.processData(type)

        assertEquals(expectedResult, actualResult)
    }
}
