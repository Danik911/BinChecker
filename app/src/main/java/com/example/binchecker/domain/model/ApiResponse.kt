package com.example.binchecker.domain.model


import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val bank: Bank ,
    val brand: String,
    val country: Country,
    val number: Number,
    val prepaid: Boolean,
    val scheme: String,
    val type: String
)