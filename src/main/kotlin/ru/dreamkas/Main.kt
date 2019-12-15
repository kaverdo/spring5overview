package ru.dreamkas

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner
import org.springframework.core.type.filter.AnnotationTypeFilter
import ru.dreamkas.core.Scenario
import kotlin.time.ExperimentalTime
import kotlin.time.MonoClock
import kotlin.time.measureTime

open class Main {
    fun start() {
        val coreServiceCtx = AnnotationConfigApplicationContext()
        val coreScanner = ClassPathBeanDefinitionScanner(coreServiceCtx)
        coreScanner.resetFilters(false)
        coreScanner.addIncludeFilter(AnnotationTypeFilter(Scenario::class.java))
        coreScanner.scan("ru.dreamkas.db")
        coreServiceCtx.refresh()


        val beans1 = coreServiceCtx.beanDefinitionNames
                .map { coreServiceCtx.getBean(it).javaClass.name }
                .filter { it.startsWith("ru.dreamkas") }
        println("Loaded beans1:\n${beans1.joinToString(separator = "\n")}")


        val basePackage = "ru.dreamkas.touch"
        val context = AnnotationConfigApplicationContext()
        val scanner = ClassPathBeanDefinitionScanner(context)
        scanner.resetFilters(false)
        scanner.addIncludeFilter(AnnotationTypeFilter(Scenario::class.java))
        scanner.scan(basePackage)
        context.parent = coreServiceCtx
        context.refresh()

        val beans = context.beanDefinitionNames
                .map { context.getBean(it).javaClass.name }
                .filter { it.startsWith("ru.dreamkas") }

        println("Loaded beans:\n${beans.joinToString(separator = "\n")}")

        context.getBean(ru.dreamkas.core.MenuScenario::class.java).start()
    }

}

@UseExperimental(ExperimentalTime::class)
fun main() {
    println(MonoClock.measureTime {
        Main().start()
    }.toLongMilliseconds())
}