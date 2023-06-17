package com.example.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import com.example.models.User
import io.ktor.server.config.*
import java.util.*

class TokenManager(private val config: HoconApplicationConfig) {

    private val audience = config.property("audience").getString()
    private val secret = config.property("secret").getString()
    private val issuer = config.property("issuer").getString()
    private val expirationDate = System.currentTimeMillis() + 600000;

    // Генерация токена после авторизации
    fun generateJwtToken(user: User): String {

        val token = JWT.create()
            .withAudience(audience)
            .withIssuer(issuer)
            .withClaim("userName", user.userMail)
            .withClaim("userId", user.userId)
            .withExpiresAt(Date(expirationDate))
            .sign(Algorithm.HMAC256(secret))

        return token

    }

        // Верификация токена на endpoints
        fun verifyJwtToken(): JWTVerifier {
            return JWT.require(Algorithm.HMAC256(secret))
                .withAudience(audience)
                .withIssuer(issuer)
                .build()
        }

    // После прохода успешного endpoint в случае важных действий - берется id через токен
    fun getUserIdFromToken(token: String): Int? {
        val decodedJWT: DecodedJWT = JWT.decode(token)
        return decodedJWT.getClaim("userId").asInt()
    }
}