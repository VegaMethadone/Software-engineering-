package com.example.routes

import com.auth0.jwt.exceptions.JWTVerificationException
import com.example.models.Order
import com.example.models.sentOrder
import com.example.utils.TokenManager
import com.typesafe.config.ConfigFactory
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.ordering(){
    // создание токенМенеджера
    val tokenManager = TokenManager(HoconApplicationConfig(ConfigFactory.load()))

    route("/order")
    {
        post {

            val token = call.request.headers["Authorization"] ?: ""

            try {
                // Проверка JWT-токена
                val verifier = tokenManager.verifyJwtToken()
                val decodedToken = verifier.verify(token)

                // Токен прошел верификацию, обработка заказа
                val order = call.receive<Order>()

                val id = tokenManager.getUserIdFromToken(token)
                if (id != null) {
                    order.userId = id
                }
                // Отпарвка заказа в бд
                sentOrder(order)
                call.respondText("Order created", status = HttpStatusCode.Created)

            } catch  (_: JWTVerificationException) {
                // Обрабокта исключения
                call.respondText("Invalid token", status = HttpStatusCode.Unauthorized)
            }

        }
    }
}