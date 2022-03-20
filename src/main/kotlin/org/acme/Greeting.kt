package org.acme

import com.fasterxml.jackson.annotation.JsonProperty

data class Greeting(
    @field:JsonProperty("message")
    val message : String? = null
)
