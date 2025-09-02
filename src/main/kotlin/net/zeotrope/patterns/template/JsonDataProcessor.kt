package net.zeotrope.patterns.template

import org.springframework.stereotype.Component

@Component
class JsonDataProcessor : ProcessorTemplate() {
    override fun loadData() = "Loading JSON data..."
    override fun processData() = "Processing JSON data..."
}
