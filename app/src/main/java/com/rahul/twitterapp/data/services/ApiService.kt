package com.rahul.twitterapp.data.services

import com.rahul.twitterapp.data.model.TweetListDataClass
import retrofit2.http.GET

interface ApiService {

    @GET("v3/12e80910-1b91-4212-913f-17cf3648745b")
    suspend fun getTweetList(): TweetListDataClass

    @GET("v3/f63bc431-c89b-47a4-af2a-e77da68741e4")
    suspend fun getTweetListForFollowing(): TweetListDataClass
}
