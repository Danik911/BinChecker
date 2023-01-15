package com.example.binchecker.data.remote

import com.example.binchecker.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BinListApi {

    @GET("/lookup.binlist.net/{bankBin}")
    suspend fun getBankByBin(@Path("bankBin") bankBin: String): ApiResponse
}