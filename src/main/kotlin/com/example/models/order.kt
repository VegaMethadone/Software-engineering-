package com.example.models

import kotlinx.serialization.Serializable
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

@Serializable
data class Order(
    val city: String,
    val address: String,
    val dateOfDelivery: String,
    val timeOfDelivery: String,
    val ratClass: String,
    val ratColor: String,
    val skills: Array<String>,
    val statusOrder: String,
    var userId: Int
)

fun sentOrder(order: Order){
    val client = KMongo.createClient()
    val dataBase = client.getDatabase("Ratatui")
    val col = dataBase.getCollection<Order>("Orders")
    col.insertOne(order)
}
