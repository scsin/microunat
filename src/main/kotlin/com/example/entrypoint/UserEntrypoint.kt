package com.example.entrypoint

import com.example.domain.User
import com.example.domain.ChuckNorrisJoke
import com.example.service.UserService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.QueryValue

@Controller("/users")
class UserEntrypoint(
    private val userService: UserService
) {

    @Get
    fun getAllUsers(): HttpResponse<List<User>> {
        return HttpResponse.ok(userService.getAll())
    }

    @Get("{id}")
    fun getUserById(@PathVariable("id") id: Long): HttpResponse<User> {
        return userService.findById(id)
            ?.let { HttpResponse.ok(it) }
            ?: HttpResponse.notFound()
    }

    @Post
    fun createUser(user: User): HttpResponse<User> {
        return HttpResponse.created(userService.create(user))
    }

    @Get("searchName")
    fun findUser(@QueryValue("name") name: String): HttpResponse<List<String>> {
        return HttpResponse.ok(userService.find(name))
    }

    @Get("searchAge")
    fun findUser(): HttpResponse<List<User>> {
        return HttpResponse.ok(userService.findAge())
    }


    @Get("joke")
    fun getChuckJoke(): HttpResponse<ChuckNorrisJoke> {
        return HttpResponse.ok(userService.getChuckJoke());
    }

}
