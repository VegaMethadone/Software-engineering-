package com.example.plugins

import com.example.routes.login
import com.example.routes.registrationPerson
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        registrationPerson()
        login()


    }
}