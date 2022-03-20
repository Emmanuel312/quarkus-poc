package org.acme.health

import org.eclipse.microprofile.health.HealthCheck
import org.eclipse.microprofile.health.HealthCheckResponse
import org.eclipse.microprofile.health.Liveness
import org.eclipse.microprofile.health.Readiness
import javax.enterprise.context.ApplicationScoped
import kotlin.random.Random

@Liveness
@ApplicationScoped
class LivenessHealthCheckImpl : HealthCheck {

    override fun call(): HealthCheckResponse {
        val randomBoolean = Random.nextBoolean()

        if(randomBoolean) return HealthCheckResponse.up("I'm live!")

        return HealthCheckResponse.down("I'm not live yet")
    }
}