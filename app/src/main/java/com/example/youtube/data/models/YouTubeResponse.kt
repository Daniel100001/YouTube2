package com.example.youtube.data.models

import com.google.gson.annotations.SerializedName

data class YouTubeResponse<T>(

    @SerializedName("kind")
    val king: String,

    @SerializedName("etag")
    val etag: String,

    @SerializedName("items")
    val items : List<T>
)