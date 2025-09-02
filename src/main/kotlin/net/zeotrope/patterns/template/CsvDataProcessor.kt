package net.zeotrope.patterns.template

import org.springframework.stereotype.Component

@Component
class CsvDataProcessor : ProcessorTemplate() {
    override fun loadData() = "Loading CSV data..."
    override fun processData() = "Processing CSV data..."
}
