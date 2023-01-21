package com.example.binchecker.di

import com.example.binchecker.data.remote.BinApi
import com.example.binchecker.data.repository.RemoteDataSourceImpl
import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.domain.repository.LocalDataSource
import com.example.binchecker.domain.repository.RemoteDataSource
import com.example.binchecker.util.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .callTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json { ignoreUnknownKeys = true }
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, json: Json): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideBinApi(retrofit: Retrofit): BinApi {
        return retrofit.create(BinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDatasource(
        binApi: BinApi,
       localDataSource: LocalDataSource,
    ): RemoteDataSource {
        return RemoteDataSourceImpl(
            binApi = binApi,
            localDataSource = localDataSource
        )
    }

}