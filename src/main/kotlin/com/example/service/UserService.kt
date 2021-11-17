package com.example.service

import com.example.domain.User
import com.example.http.ChuckJokesClient
import com.example.domain.ChuckNorrisJoke
import com.example.repository.UserRepository
import jakarta.inject.Singleton

@Singleton
class UserService(
    private val userRepository: UserRepository,
    private val chuckJokesClient: ChuckJokesClient,
) {

    fun getAll(): List<User> = userRepository.findAll().toList()

    fun find(name: String): List<String> = userRepository.findName(name)
    fun findAge(): List<User> = userRepository.findOrderByAge()

    fun findById(id: Long): User? = userRepository.findById(id).orElse(null)

    fun create(user: User): User = userRepository.save(user)

    fun getChuckJoke(): ChuckNorrisJoke {
        return chuckJokesClient.random().body()!!
    }

}