package com.example.routes

import com.example.models.Login
import com.example.models.autorisation
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.login(){
    route("/login"){
        post {
            val person = call.receive<Login>()
            val result = autorisation(person)

            if(result == false)
            {
                call.respondText("Wrong mail or password", status = HttpStatusCode.NotFound)
            }
            else
            {
                call.respondText("Successful autorisation", status = HttpStatusCode.Accepted)
            }

        }
    }

}