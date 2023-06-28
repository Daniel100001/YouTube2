package com.example.youtube.data.models.category

import com.google.gson.annotations.SerializedName

data class Snippet(

    @SerializedName("localized")
    val localized: Localized,

    @SerializedName("thumbnails")
    val thumbnails: ThumbnailsYt,

    @SerializedName("channelId")
    val channelId: String
)