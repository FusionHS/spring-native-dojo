package com.fusionhs.springnativedojo.rest

import com.fusionhs.springnativedojo.logging.LogAroundMethod
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@LogAroundMethod
class DojoControllerImpl : DojoController {

    @GetMapping
    override fun helloDojo(): String {
        return "hello dojo"
    }
}