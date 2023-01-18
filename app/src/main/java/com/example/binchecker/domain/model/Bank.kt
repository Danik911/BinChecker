package com.example.binchecker.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.binchecker.util.Constants.BANK_TABLE
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
@Entity(tableName = BANK_TABLE)
data class Bank(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val city: String,
    @SerialName("name") val bankName: String,
    val phone: String,
    val url: String
)