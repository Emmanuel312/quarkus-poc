package com.clean.arch.quarkus.infra.kafka

import com.clean.arch.quarkus.infra.Greeting
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import io.smallrye.reactive.messaging.MutinyEmitter
import io.smallrye.reactive.messaging.kafka.Record
import org.eclipse.microprofile.reactive.messaging.Channel
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class DummyKafkaProducer(
    @Channel("sink-kafka-topic")
    private val emitter: MutinyEmitter<Record<String, Greeting>>
) {

    fun publish(greeting: Greeting) {
        emitter
            .send(Record.of(UUID.randomUUID().toString(), greeting))
            .catch { println(it.message) }
    }
}

fun <T> Uni<T>.catch(handler: (message: Throwable) -> Unit) {
    this.subscribe().with({}) { failure -> handler(failure) }
}

fun <T> Multi<T>.catch(handler: (message: Throwable) -> Unit) {
    this.subscribe().with({}) { failure -> handler(failure) }
}