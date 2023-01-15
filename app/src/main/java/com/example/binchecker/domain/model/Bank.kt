package com.example.binchecker.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.binchecker.util.Constants.BANK_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = BANK_TABLE)
data class Bank(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val city: String,
    val name: String,
    val phone: String,
    val url: String
)