package com.example.service

class ServiceHello(
    private val y: Service2
) {

    fun x() = "Hello"

    fun y() = y.y()

}

class Service2 {

    fun y() = "Hello"
    fun z() { TODO("chamada api") }

}