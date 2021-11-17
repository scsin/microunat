package com.example.repository

import com.example.domain.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findName(name: String): List<String>
    fun findOrderByAge(): List<User>

}