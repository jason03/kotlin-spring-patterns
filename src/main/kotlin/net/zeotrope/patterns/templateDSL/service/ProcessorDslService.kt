package net.zeotrope.patterns.templateDSL.service

import net.zeotrope.patterns.common.DataType
import net.zeotrope.patterns.templateDSL.ProcessorDsl
import org.springframework.stereotype.Service

@Service
class ProcessorDslService {

    fun processData(type: DataType) =
        when (type) {
            DataType.CSV ->
                ProcessorDsl.dataProcessor {
                    load { "Loading CSV data..." }
                    analyse { "Analysing CSV data..." }
                    save { "Saving CSV data..." }
                }
            DataType.JSON ->
                ProcessorDsl.dataProcessor {
                    load { "Loading JSON data..." }
                    analyse { "Analysing JSON data..." }
                    save { "Saving JSON data..." }
                }
        }
}
