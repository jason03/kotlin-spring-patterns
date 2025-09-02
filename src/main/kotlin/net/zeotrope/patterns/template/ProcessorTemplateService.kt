package net.zeotrope.patterns.template

import org.springframework.stereotype.Service

@Service
class ProcessorTemplateService {

    fun processData(type: DataType) =
        when (type) {
            DataType.CSV -> CsvDataProcessor().process()
            DataType.JSON -> JsonDataProcessor().process()
        }
}
