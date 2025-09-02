package net.zeotrope.patterns.template.service

import net.zeotrope.patterns.common.DataType
import net.zeotrope.patterns.template.CsvDataProcessor
import net.zeotrope.patterns.template.JsonDataProcessor
import org.springframework.stereotype.Service

@Service
class ProcessorTemplateService {

    fun processData(type: DataType) =
        when (type) {
            DataType.CSV -> CsvDataProcessor().process()
            DataType.JSON -> JsonDataProcessor().process()
        }
}
