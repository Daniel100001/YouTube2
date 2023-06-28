package com.example.youtube.data.models.category

import com.google.gson.annotations.SerializedName

data class VideoCategoryModel(
    @SerializedName("kind")
    val kind: String,

    @SerializedName("etag")
    val etag: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("snippet")
    val snippet: Snippet
)