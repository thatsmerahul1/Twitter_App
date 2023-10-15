package com.rahul.twitterapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahul.twitterapp.data.model.TweetListDataClass
import com.rahul.twitterapp.repository.Repository
import com.rahul.twitterapp.usecases.GetTweetsForFollowingUseCase
import kotlinx.coroutines.launch

class FollowingViewModel(private val repository: Repository) : ViewModel() {
    private val _tweets = MutableLiveData<TweetListDataClass>().apply {
        value = TweetListDataClass()
    }
    val tweets: LiveData<TweetListDataClass> = _tweets

    fun getTweets() {
        viewModelScope.launch {
            try {
                val tweetsUseCase = GetTweetsForFollowingUseCase(repository)
                val tweetsResult: Result<TweetListDataClass> = tweetsUseCase.execute()
                _tweets.value = tweetsResult.getOrDefault(TweetListDataClass())
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }
    }

    companion object {
        const val TAG = "Following_View_Model"
    }
}