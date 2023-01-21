package com.example.binchecker.domain.model


import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import retrofit2.http.OPTIONS

@Serializable
data class ApiResponse(
    val bank: Bank? = null,
    val brand: String? = null,
    val country: Country? = null,
    val number: Number? = null,
    val prepaid: Boolean? = null,
    val scheme: String? = null,
    val type: String? = null,

    @Transient
    val error: Exception? = null,
    @Transient
    val success: Boolean = false,
)