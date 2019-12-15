package ru.dreamkas.core

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component
import org.springframework.stereotype.Indexed

@Component
@Indexed
annotation class Scenario(
        @get:AliasFor(annotation = Component::class, attribute = "value")
        val value: String = ""
)