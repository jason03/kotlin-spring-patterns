package net.zeotrope.patterns.template

abstract class ProcessorTemplate {

    fun process(): String {
        val responses = mutableListOf<String>()

        responses.addLast(loadData())
        responses.addLast(processData())
        responses.addLast(saveData())
        return responses.joinToString()
    }

    fun saveData() = "Saving data to database."

    abstract fun loadData(): String
    abstract fun processData(): String
}
