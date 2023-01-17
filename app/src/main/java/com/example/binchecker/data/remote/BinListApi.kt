package com.example.binchecker.data.remote

import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.util.Resource
import retrofit2.http.GET
import retrofit2.http.Path

interface BinListApi {

    @GET("/45717360")
    suspend fun getBankByBin(): Resource<ApiResponse>
}