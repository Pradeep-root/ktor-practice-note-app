package com.example.routes

import com.example.data.*
import com.example.data.collections.*
import com.example.data.requests.*
import com.example.data.responses.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.HttpStatusCode.Companion.BadRequest
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.registerRoute(){
    route("/register"){
        post {
            val request = try {
                call.receive<AccountRequest>()
            }catch (e : ContentTransformationException){
                call.respond(BadRequest)
                return@post
            }
            val userExists = checkIfUserExists(request.email)
            if(!userExists){
                if(registerUser(User(request.email, request.password))){
                    call.respond(OK, SimpleResponse(true, "Successfully registered"))
                }else{
                    call.respond(OK, SimpleResponse(false, "An unknown error"))
                }
            }else{
                call.respond(OK, SimpleResponse(false, "The email is already registered"))
            }
        }
    }
}