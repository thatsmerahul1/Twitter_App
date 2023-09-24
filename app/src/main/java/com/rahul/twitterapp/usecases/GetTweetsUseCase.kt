package com.rahul.twitterapp.usecases

import com.rahul.twitterapp.repository.Repository
import com.rahul.twitterapp.data.model.TweetListDataClass

class GetTweetsUseCase (private val repository: Repository) {
    suspend fun execute(): TweetListDataClass {
        return repository.fetchTweetData()
    }
}
