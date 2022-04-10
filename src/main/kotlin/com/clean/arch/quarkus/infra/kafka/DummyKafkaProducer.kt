package com.clean.arch.quarkus.infra.kafka

import com.clean.arch.quarkus.infra.Greeting
import io.smallrye.mutiny.coroutines.awaitSuspending
import io.smallrye.mutiny.subscription.MultiEmitter
import io.smallrye.reactive.messaging.MutinyEmitter
import io.smallrye.reactive.messaging.kafka.Record
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class DummyKafkaProducer(
    @Channel("sink-kafka-topic")
    private val emitter: MutinyEmitter<Record<String, Greeting>>
) {

    suspend fun publish(greeting: Greeting) {
        emitter.send(Record.of(UUID.randomUUID().toString(), greeting)).awaitSuspending()
    }
}