package com.senticlaw

import plugins.ExamplePlugin

object PluginManager {

    fun runPlugin(name: String) {
        when (name) {
            "example" -> {
                val plugin = ExamplePlugin()
                plugin.execute()
            }
            else -> println("Plugin not found")
        }
    }
}
