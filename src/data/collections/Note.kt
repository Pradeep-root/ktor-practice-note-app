package com.example.data.collections

import org.bson.codecs.pojo.annotations.*
import org.bson.types.*

data class Note(
    val title : String,
    val content : String,
    val data : Long,
    val owners : List<String>,
    val color : String,
    @BsonId
    val id : String = ObjectId().toString()
)