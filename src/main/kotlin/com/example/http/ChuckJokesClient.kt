package com.example.http

import com.example.domain.ChuckNorrisJoke
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("https://api.chucknorris.io/jokes/")
interface ChuckJokesClient {

    @Get("random")
    fun random(): HttpResponse<ChuckNorrisJoke>

}
