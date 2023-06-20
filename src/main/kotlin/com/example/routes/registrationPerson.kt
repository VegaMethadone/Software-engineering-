package com.example.routes

import com.example.models.Person
import com.example.models.addPersonMongoDB
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.registrationPerson(){
    route("/registrationPerson") {
        post {
            val person = call.receive<Person>()
            //By default, use id in this data equal to 0 and increase in addPersonMongoDB func
            addPersonMongoDB(person)
            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
        }
    }
}