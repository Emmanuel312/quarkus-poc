package com.clean.arch.quarkus.infra

import com.fasterxml.jackson.annotation.JsonProperty

data class Greeting(
    @field:JsonProperty("message")
    val message : String? = null
)
