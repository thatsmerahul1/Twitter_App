package com.rahul.twitterapp.usecases

import com.rahul.twitterapp.repository.Repository
import com.rahul.twitterapp.data.model.TweetListDataClass

class GetTweetsForFollowingUseCase (private val repository: Repository) {
    suspend fun execute(): Result<TweetListDataClass> {
        return try {
            val response = repository.fetchTweetDataForFollowing()
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(RuntimeException("Response error: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
