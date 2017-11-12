package ru.dreamkas.touch

import ru.dreamkas.core.Scenario
import ru.dreamkas.core.SettingsScenario

@Scenario
class SettingsScenarioImpl : SettingsScenario {
    override fun start() {
        println("${this.javaClass.simpleName}.start")
    }
}