package com.example.binchecker.data.remote

import com.example.binchecker.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BinApi {

    @GET("/{bin}")
    suspend fun getBankInfo(@Path("bin") bin: String): ApiResponse

}

