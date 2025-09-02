package net.zeotrope.patterns.templateHoF

fun processData(loadAction: () -> String, analyseAction: () -> String, saveAction: () -> String): List<String> {
    val loadResult = loadAction()
    val analyseResult = analyseAction()
    val saveResult = saveAction()
    return listOf(loadResult, analyseResult, saveResult)
}
