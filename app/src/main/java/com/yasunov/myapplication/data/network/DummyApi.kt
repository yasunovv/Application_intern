package com.yasunov.myapplication.data.network


import com.yasunov.myapplication.data.network.model.ProductsDto
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyApi {
    @GET("products")
    suspend fun getUsers(@Query("limit") limit: Int, @Query("skip") skip: Int): ProductsDto

    companion object {
        private const val BASE_URL = "https://dummyjson.com/"
        @OptIn(ExperimentalSerializationApi::class)
        private val json = Json {
            ignoreUnknownKeys = true
            explicitNulls = false
        }

        @OptIn(ExperimentalSerializationApi::class)
        operator fun invoke(): DummyApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                json
                    .asConverterFactory(
                    "application/json; charset=UTF8".toMediaType(),

                )
            )
            .client(OkHttpClient())
            .build()
            .create(DummyApi::class.java)
    }
}
