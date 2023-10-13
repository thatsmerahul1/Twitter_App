package com.rahul.twitterapp.repository

import com.rahul.twitterapp.data.services.ApiService
import com.rahul.twitterapp.data.model.TweetListDataClass
import retrofit2.Response

class Repository(private val apiService: ApiService) {
    suspend fun fetchTweetData(): Response<TweetListDataClass> {
        return apiService.getTweetList()
    }

    suspend fun fetchTweetDataForFollowing(): Response<TweetListDataClass> {
        return apiService.getTweetListForFollowing()
    }
}
