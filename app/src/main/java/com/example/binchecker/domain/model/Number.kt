package com.example.binchecker.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Number(
    val length: Int,
    val luhn: Boolean
)