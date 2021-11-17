package com.example.domain

import io.micronaut.core.annotation.Introspected
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
@Introspected
data class User(
    @Id
    @GeneratedValue
    val id: Long?,
    val name: String,
    val age: Int
)