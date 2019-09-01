package com.raychenon.androidx.jetpack.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitFactory {

    // https://android.jlelse.eu/kotlin-coroutines-and-retrofit-e0702d0b8e8f
    fun getAlbumServiceInstance(): AlbumService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://api.deezer.com/2.0/")
            .client(
                OkHttpClient.Builder()
                    .build()
            )
            .build()
        val service = retrofit.create(AlbumService::class.java)

        return service
    }
}
