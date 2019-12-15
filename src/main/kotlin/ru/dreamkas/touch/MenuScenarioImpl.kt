package ru.dreamkas.touch

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import ru.dreamkas.core.MenuScenario
import ru.dreamkas.core.Scenario
import ru.dreamkas.core.SettingsScenario

@Scenario("menu")
class MenuScenarioImpl(
        @Autowired
        @Qualifier("tunes")
        private val settings: SettingsScenario
) : MenuScenario {

    override fun start() {
        println("${this.javaClass.simpleName}.start")
        settings.start()
    }
}