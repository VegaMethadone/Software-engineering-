package com.example.models

import kotlinx.serialization.Serializable
import org.litote.kmongo.KMongo
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

@Serializable
data class UserId(
    var userId: Int
)

@Serializable
data class Person(
    var personId: Int,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val email: String,
    val password: String
)

fun addPersonMongoDB(person: Person) {
    val client = KMongo.createClient()
    val dataBase = client.getDatabase("Ratatui")

    val colId = dataBase.getCollection<UserId>("globalVariable")
    val result: UserId? = colId.findOne()
    val newUserId = if (result == null) {
        UserId(userId = 1)
    } else {
        UserId(userId = result.userId + 1)
    }
    colId.drop() // Убивает старую коллецию
    colId.insertOne(newUserId) // Создает и добавляет новое значение
    person.personId = newUserId.userId
    val col = dataBase.getCollection<Person>("Persons")
    col.insertOne(person)
}

