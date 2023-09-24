package com.rahul.twitterapp.data.model

data class TweetListItemDataClass(
    val count: CountDataClass,
    val date: String,
    val displayName: String,
    val id: Int,
    val message: String,
    val profilePicturePath: String,
    val userName: String,
    var isVerified: Boolean = false
)