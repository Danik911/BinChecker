package com.example.binchecker.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.binchecker.util.Constants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
@Entity(tableName = Constants.BANK_TABLE)
data class Bank(
    @Transient
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val city: String,
    @SerialName("name") val bankName: String,
    val phone: String,
    val url: String
)