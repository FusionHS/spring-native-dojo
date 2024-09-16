package com.fusionhs.springnativedojo.logging

import com.fusionhs.springnativedojo.rest.DojoController
import org.springframework.aot.hint.RuntimeHints
import org.springframework.aot.hint.RuntimeHintsRegistrar

class CustomHints : RuntimeHintsRegistrar {
    override fun registerHints(hints: RuntimeHints, classLoader: ClassLoader?) {
        hints.proxies().registerJdkProxy(DojoController::class.java)
        hints.resources().registerPattern("resource-*.txt")
    }
}
