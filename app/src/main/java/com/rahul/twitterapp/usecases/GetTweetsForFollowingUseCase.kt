package com.rahul.twitterapp.usecases

import com.rahul.twitterapp.repository.Repository
import com.rahul.twitterapp.data.model.TweetListDataClass

class GetTweetsForFollowingUseCase (private val repository: Repository) {
    suspend fun execute(): TweetListDataClass {
        return repository.fetchTweetDataForFollowing()
    }
}
