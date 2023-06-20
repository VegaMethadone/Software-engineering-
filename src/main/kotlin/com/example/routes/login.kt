package com.example.routes

import com.example.models.*
import com.example.utils.TokenManager
import com.mongodb.client.model.Filters.eq
import com.typesafe.config.ConfigFactory
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.litote.kmongo.KMongo
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection


fun Route.login(){

    val tokenManager = TokenManager(HoconApplicationConfig(ConfigFactory.load()))

    route("/login"){
        post {
            val person = call.receive<LoginRequest>()
            val result = autorisation(person)

            if(result == false)
            {
                call.respondText("Wrong mail or password", status = HttpStatusCode.NotFound)
            }
            else
            {
                val client = KMongo.createClient()
                val dataBase = client.getDatabase("Ratatui")
                val col  = dataBase.getCollection<Person>("Persons")

                val filter = eq("email", person.mail)
                val tmp = col.findOne(filter)

                val user = User(
                    userMail = tmp?.email,
                    userId = tmp?.personId
                )

                val token = tokenManager.generateJwtToken(user)

                // Запаковка в json токен
                val tokenResult = LoginResponse(token)
                call.respond(HttpStatusCode.Accepted, tokenResult)
            }

        }
    }

}