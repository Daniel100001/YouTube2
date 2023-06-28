package com.example.youtube.data.repositories

import com.example.youtube.base.BaseRepository
import com.example.youtube.data.remote.apiservices.VideoCategoryApiService
import javax.inject.Inject

class VideoCategoryRepository @Inject constructor(
    private val service: VideoCategoryApiService
) : BaseRepository() {

    fun fetchVideoCategory() = doRequest {
        service.fetchVideoCategory()
    }
}
