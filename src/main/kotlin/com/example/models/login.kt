package com.example.models

import com.mongodb.client.model.Filters.eq
import kotlinx.serialization.Serializable
import org.litote.kmongo.KMongo
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

@Serializable
data class Login(
    val mail: String,
    val password: String
)

fun autorisation(login: Login): Boolean  {
    val client  = KMongo.createClient()
    val dataBase = client.getDatabase("Ratatui")
    val col  = dataBase.getCollection<Person>("Persons")

    val filter = eq("email", login.mail)
    val result = col.findOne(filter)


    var flag = false
    if (result != null) {
        if(result.password == login.password)
        {
            flag = true
        }
    }
    return flag
}