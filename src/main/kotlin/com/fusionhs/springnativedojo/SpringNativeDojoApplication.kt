package com.fusionhs.springnativedojo

import com.fusionhs.springnativedojo.logging.CustomHints
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ImportRuntimeHints

@SpringBootApplication
@ImportRuntimeHints(CustomHints::class)
class SpringNativeDojoApplication

fun main(args: Array<String>) {
    runApplication<SpringNativeDojoApplication>(*args)
}
