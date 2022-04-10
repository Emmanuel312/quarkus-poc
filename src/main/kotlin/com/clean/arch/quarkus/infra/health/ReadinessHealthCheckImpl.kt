package com.clean.arch.quarkus.infra.health

import org.eclipse.microprofile.health.HealthCheck
import org.eclipse.microprofile.health.HealthCheckResponse
import org.eclipse.microprofile.health.Readiness
import javax.enterprise.context.ApplicationScoped
import kotlin.random.Random

@Readiness
@ApplicationScoped
class ReadinessHealthCheckImpl : HealthCheck {

    override fun call(): HealthCheckResponse {
        val randomBoolean = Random.nextBoolean()

        if(randomBoolean) return HealthCheckResponse.up("I'm ready!")

        return HealthCheckResponse.down("I'm not ready yet")
    }
}