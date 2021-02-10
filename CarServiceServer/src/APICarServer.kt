package com.varenie

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

data class Author(val name: String, val surname: String, val countOfStrings: Int)

fun main(args: Array<String>) {
    val jsonResponse = """{
        "id": 1,
        "task": "Pay waterbill",
        "description": "Pay water bill today",
    }"""

    embeddedServer(Netty, 8080){
//      Установка хэдэров
        install(DefaultHeaders) {
            header(HttpHeaders.Server, "My Server")
        }

//      Для автоматического преобразования дата класса в JSON
        install(ContentNegotiation){
            gson{
                setPrettyPrinting()
            }
        }

//      Маршрутизация запросов
        routing {
            get("/todo") {
                call.respondText(jsonResponse, ContentType.Application.Json)
            }
            get("/users"){
                call.respondText("Тута ответ из бд юзеров например")
            }
            get("/cars") {
                call.respondText("Тут машины например")
            }
            get("/author") {
                val author = Author("Sanya", "Kakanya", 5)
                call.respond(author)
            }
        }


    }.start(wait = true)
}