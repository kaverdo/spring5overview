package ru.dreamkas.touch

import ru.dreamkas.core.Scenario
import ru.dreamkas.core.SettingsScenario

@Scenario("tunes")
class SettingsScenarioImpl : SettingsScenario {
    override fun start() {
        println("${this.javaClass.simpleName}.start")
    }
}