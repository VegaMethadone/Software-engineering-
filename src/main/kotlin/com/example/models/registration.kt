package com.example.models

import kotlinx.serialization.Serializable
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

@Serializable
data class Person(
    val firstName: String,
    val lastName: String,
    val phone: String,
    val email: String,
    val password: String)

fun addPersonMongoDB(person: Person)
{
    val client  = KMongo.createClient()
    val dataBase = client.getDatabase("Ratatui")
    val col  = dataBase.getCollection<Person>("Persons")

    col.insertOne(person)
}