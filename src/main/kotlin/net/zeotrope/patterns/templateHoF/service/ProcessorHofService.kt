package net.zeotrope.patterns.templateHoF.service

import net.zeotrope.patterns.common.DataType
import net.zeotrope.patterns.templateHoF.processData
import org.springframework.stereotype.Service

@Service
class ProcessorHofService {
    fun process(type: DataType) =
        when (type) {
            DataType.CSV -> {
                processData(
                    loadAction = { "Loading CSV data..." },
                    analyseAction = { "Analysing CSV data..." },
                    saveAction = { "Saving CSV data..." }
                ).joinToString()
            }
            DataType.JSON -> {
                processData(
                    loadAction = { "Loading JSON data..." },
                    analyseAction = { "Analysing JSON data..." },
                    saveAction = { "Saving JSON data..." }
                ).joinToString()
            }
        }
}
