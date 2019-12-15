package ru.dreamkas.touch

import ru.dreamkas.core.Scenario
import ru.dreamkas.core.SettingsScenario
import ru.dreamkas.db.DatabaseService

@Scenario("tunes")
class SettingsScenarioImpl(
        val db: DatabaseService
) : SettingsScenario {
    override fun start() {
        println("${this.javaClass.simpleName}.start")
        println(db.javaClass.simpleName)
    }
}