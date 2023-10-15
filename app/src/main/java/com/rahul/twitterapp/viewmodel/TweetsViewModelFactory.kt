package com.rahul.twitterapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rahul.twitterapp.constants.AppConstants
import com.rahul.twitterapp.repository.Repository

class TweetsViewModelFactory(private val repository: Repository, private val viewModelType: String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (viewModelType == AppConstants.VIEW_MODEL_KEY_FOLLOWING) {
            return FollowingViewModel(repository) as T
        } else if(viewModelType == AppConstants.VIEW_MODEL_KEY_FOR_YOU) {
            return ForyouViewModel(repository) as T
        }
        return super.create(modelClass)
    }
}