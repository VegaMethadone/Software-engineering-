package com.example.plugins

import com.example.routes.getAccount
import com.example.routes.login
import com.example.routes.ordering
import com.example.routes.registrationPerson
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import org.litote.kmongo.index

fun Application.configureRouting() {
    routing {

        // API request POST-GET
        registrationPerson()
        login()
        ordering()
        getAccount()
        index()



        static("/static") {
            resources("files")
        }


    }
}