package com.rahul.twitterapp.repository

import com.rahul.twitterapp.data.services.ApiService
import com.rahul.twitterapp.data.model.TweetListDataClass

class Repository(private val apiService: ApiService) {
    suspend fun fetchTweetData(): TweetListDataClass {
        return apiService.getTweetList()
    }

    suspend fun fetchTweetDataForFollowing(): TweetListDataClass {
        return apiService.getTweetListForFollowing()
    }
}
