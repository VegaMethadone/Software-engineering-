package com.example.models

import com.mongodb.client.model.Filters.eq
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection


fun getAccountData(id: Int): MutableList<Order> {
    // Подключение к базе данных
    val client = KMongo.createClient()
    val dataBase = client.getDatabase("Ratatui")
    val col  = dataBase.getCollection<Order>("Orders")

    // Создание фильтра, по которому буду искать заказы
    val filter = eq("userId", id)

    // Объявление мутабл массива, в который буду складывать заказы
    val orders = mutableListOf<Order>()

    // Прохожуст по массиву
    // Можно сделать хеш-индексы id и вытаскивать все нужные хеши
    val cursor = col.find(filter).iterator()
    while(cursor.hasNext())
    {
        val order = cursor.next()
        orders.add(order)
    }
    client.close()

    return orders
}


