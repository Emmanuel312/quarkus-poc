package com.clean.arch.quarkus.infra

import javax.enterprise.context.ApplicationScoped
import javax.inject.Named
import javax.ws.rs.Produces

@ApplicationScoped
class StringConfig {

    @Produces
    @Named("string1")
    fun someString1() = "String1"

    @Produces
    @Named("string2")
    fun someString2() = "String2"
}