package com.raychenon.androidx.jetpack.data

import com.raychenon.androidx.jetpack.models.AlbumResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumService {

    @GET("/user/{id}/albums")
    suspend fun getAlbums(@Path("id") id: Int): AlbumResponse

    @GET("/user/{id}/albums")
    suspend fun getAlbumsResponse(@Path("id") id: Int): Response<AlbumResponse>
}
