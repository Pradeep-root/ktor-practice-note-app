package com.example.data.collections

import de.undercouch.bson4jackson.types.*
import org.bson.codecs.pojo.annotations.*
import org.bson.types.ObjectId

data class User(
    val email : String,
    val password : String,
    @BsonId
    val id : String = ObjectId().toString()
)