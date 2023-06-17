package com.example.routes

import com.auth0.jwt.exceptions.JWTVerificationException
import com.example.models.Order
import com.example.models.getAccountData
import com.example.utils.TokenManager
import com.typesafe.config.ConfigFactory
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


fun Route.getAccount(){

    val tokenManager = TokenManager(HoconApplicationConfig(ConfigFactory.load()))

    route("/account"){
        get{
            val token = call.request.headers["Authorization"] ?: ""

            try{
                // Проверка JWT-токена
                val verifier = tokenManager.verifyJwtToken()
                val decodedToken = verifier.verify(token)

                // Конвертация токена в Id
                val id = tokenManager.getUserIdFromToken(token)
                var orders = mutableListOf<Order>()

                // Изъятие всех заказов по Id из бд
                if (id != null) {
                    orders = getAccountData(id)
                }

                // Упаковка заказов в json
                val json = Json.encodeToString(orders)
                call.respond(HttpStatusCode.Found, json)

            } catch  (_: JWTVerificationException) {
                // Обрабокта исключения
                call.respondText("Invalid token", status = HttpStatusCode.Unauthorized)
            }
        }
    }
}