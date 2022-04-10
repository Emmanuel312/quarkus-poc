package com.clean.arch.quarkus.infra

import com.clean.arch.quarkus.infra.kafka.DummyKafkaProducer
import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.inject.Named
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/hello")
class ReactiveGreetingController(
    @ConfigProperty(name = "api.greeting.message")
    val message: String,
    @Named("string1")
    val string1: String,
    @Named("string2")
    val string2: String,
    val dummyKafkaProducer: DummyKafkaProducer,
) {

    @GET
    suspend fun hello(): Greeting {
        val greeting = Greeting(message = "$message $string1 $string2")
        dummyKafkaProducer.publish(greeting)

        return greeting
    }
}