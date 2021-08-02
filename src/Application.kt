package com.example

import com.example.data.*
import com.example.data.collections.*
import com.example.routes.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import kotlinx.coroutines.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing){
        registerRoute()
        loginRoute()
    }
    install(ContentNegotiation){
        gson {
            setPrettyPrinting()
        }
    }
}

