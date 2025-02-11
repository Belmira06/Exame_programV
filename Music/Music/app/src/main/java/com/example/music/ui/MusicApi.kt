package com.example.music.api

import com.example.music.Music
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.Path


interface MusicApi {
    @GET("music")
    suspend fun getAllMusic(): List<Music>


    @POST("music")
    suspend fun addMusic(@Body music: Music)

    @GET("music/genre/{genre}")
    suspend fun getMusicByGenre(@Path("genre") genre: String): List<Music>

    @GET("music/artist/{artist}")
    suspend fun getMusicByArtist(@Path("artist") artist: String): List<Music>
}
