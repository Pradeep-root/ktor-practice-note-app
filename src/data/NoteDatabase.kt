package com.example.data

import com.example.data.collections.*
import org.litote.kmongo.coroutine.*
import org.litote.kmongo.reactivestreams.*

private val client = KMongo.createClient().coroutine
private val database = client.getDatabase("NoteDatabase")
private val users = database.getCollection<User>()
private val notes = database.getCollection<Note>()

suspend fun registerUser(user : User) : Boolean{
    return users.insertOne(user).wasAcknowledged()
}