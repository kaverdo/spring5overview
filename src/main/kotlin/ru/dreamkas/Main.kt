package ru.dreamkas

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner
import org.springframework.core.type.filter.AnnotationTypeFilter
import ru.dreamkas.core.Scenario

open class Main {
    fun start() {
        val basePackage = "ru.dreamkas"
        val context = AnnotationConfigApplicationContext()
        val scanner = ClassPathBeanDefinitionScanner(context)
        scanner.resetFilters(false)
        scanner.addIncludeFilter(AnnotationTypeFilter(Scenario::class.java))
        scanner.scan(basePackage)
        context.refresh()

        val beans = context.beanDefinitionNames
                .map { context.getBean(it).javaClass.name }
                .filter { it.startsWith(basePackage) }

        println("Loaded beans:\n${beans.joinToString(separator = "\n")}")

        context.getBean(ru.dreamkas.core.MenuScenario::class.java).start()
    }

}

fun main(args: Array<String>) {
    Main().start()
}