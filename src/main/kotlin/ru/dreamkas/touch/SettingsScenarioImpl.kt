package ru.dreamkas.touch

import ru.dreamkas.core.Scenario
import ru.dreamkas.core.SettingsScenario
import ru.dreamkas.db.DatabaseService

@Scenario("tunes")
class SettingsScenarioImpl(
         db: DatabaseService
) : SettingsScenario {

    private val db: DatabaseService

    init {
        this.db = db
    }


    override fun start() {
        println("${this.javaClass.simpleName}.start")
        println(db.javaClass.simpleName)
    }
}