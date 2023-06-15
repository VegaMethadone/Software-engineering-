package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Order(
    val city: String,
    val address: String,
    val dateOfDelivery: String,
    val timeOfDelivery: String,
    val ratClass: String,
    val ratColor: String,
    val skills: Array<String>,
    val statusOrder: String
)
