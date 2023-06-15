package com.example.models

import io.ktor.server.application.*
import io.ktor.server.auth.*

// ...
fun Application.module() {
    install(Authentication)
    // ...
}
