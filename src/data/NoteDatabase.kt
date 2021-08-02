package com.example.data

import com.example.data.collections.*
import org.litote.kmongo.*
import org.litote.kmongo.coroutine.*
import org.litote.kmongo.reactivestreams.*
import org.litote.kmongo.reactivestreams.KMongo
import sun.security.util.*

private val client = KMongo.createClient().coroutine
private val database = client.getDatabase("NoteDatabase")
private val users = database.getCollection<User>()
private val notes = database.getCollection<Note>()

suspend fun registerUser(user : User) : Boolean{
    return users.insertOne(user).wasAcknowledged()
}

suspend fun checkIfUserExists(email : String) : Boolean{
    return users.findOne(User :: email eq email) != null
}

suspend fun checkPasswordForEmail(email: String, passwordToCheck: String): Boolean{
    val actualPassword = users.findOne(User :: email eq email)?.password ?: return false
    return actualPassword == passwordToCheck
}