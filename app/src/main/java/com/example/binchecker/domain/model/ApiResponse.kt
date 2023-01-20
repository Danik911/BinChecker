package com.example.binchecker.domain.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.binchecker.util.Constants
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

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