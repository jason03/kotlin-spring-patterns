package net.zeotrope.patterns.templateDSL

class ProcessorDsl {
    private lateinit var loadAction: () -> String
    private lateinit var analyseAction: () -> String
    private lateinit var saveAction: () -> String

    fun load(action: () -> String) {
        loadAction = action
    }

    fun analyse(action: () -> String) {
        analyseAction = action
    }

    fun save(action: () -> String) {
        saveAction = action
    }

    fun process(): List<String> {
        when {
            (!::loadAction.isInitialized) ||
                (!::analyseAction.isInitialized) ||
                (!::saveAction.isInitialized) -> throw IllegalStateException("Processor DSLs not initialized")
        }
        val loadResult = loadAction()
        val processResult = analyseAction()
        val saveResult = saveAction()
        return listOf(loadResult, processResult, saveResult)
    }

    companion object {
        fun dataProcessor(block: ProcessorDsl.() -> Unit): String {
            val dsl = ProcessorDsl().apply(block)
            return dsl.process().joinToString()
        }
    }
}
