package com.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val id: Int,
    val age: Int,
    val name: String,
    val portrait_path: String,

)
