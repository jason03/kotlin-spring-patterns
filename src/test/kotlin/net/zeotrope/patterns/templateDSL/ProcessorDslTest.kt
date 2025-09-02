package net.zeotrope.patterns.templateDSL

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class ProcessorDslTest {

    @Test
    fun `should initalise processor DSL and return the expected result`() {
        val expectedResult = "Loading data..., Analysing data..., Saving data..."

        val actualResult =
            ProcessorDsl.dataProcessor {
                load { "Loading data..." }
                analyse { "Analysing data..." }
                save { "Saving data..." }
            }

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `should throw an exception if Processor DSL functions aren't initialised`() {
        assertThrows<IllegalStateException> {
            ProcessorDsl.dataProcessor {}
        }
    }
}
