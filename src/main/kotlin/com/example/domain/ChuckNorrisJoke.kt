package com.example.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class ChuckNorrisJoke(
    @JsonProperty("icon_url")
    val iconUrl: String,
    val id: String,
    val url: String,
    val value: String,
)