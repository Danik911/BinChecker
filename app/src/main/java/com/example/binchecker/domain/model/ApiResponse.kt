package com.example.binchecker.domain.model


import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class ApiResponse(
    val bank: Bank? = null,
    val brand: String,
    val country: Country? = null,
    val number: Number? = null,
    val prepaid: Boolean,
    val scheme: String,
    val type: String
)