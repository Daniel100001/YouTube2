package com.example.youtube.data.remote.apiservices

import com.example.youtube.data.models.YouTubeResponse
import com.example.youtube.data.models.category.VideoCategoryModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoCategoryApiService {

    @GET("videoCategories")
    suspend fun fetchVideoCategory(
        @Query("part") part : String = "snippet",
        @Query("regionCode") regionCode: String = "ru",
        @Query("chart") chart: String = "mostPopular",

    ) : Response<YouTubeResponse<VideoCategoryModel>>
}