package com.rahul.twitterapp.listeners

interface NetworkStatusChangeListener {
    fun onNetworkStatusChanged(isNetworkAvailable: Boolean)
}