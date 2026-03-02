package com.senticlaw

object TriggerManager {

    fun handle(command: String) {
        when (command) {
            "EXECUTE_PLUGIN" -> PluginManager.runPlugin("example")
            else -> println("No matching trigger")
        }
    }
}
