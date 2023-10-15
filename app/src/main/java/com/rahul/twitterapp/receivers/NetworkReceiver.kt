package com.rahul.twitterapp.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.rahul.twitterapp.listeners.NetworkStatusChangeListener
import com.rahul.twitterapp.utils.NetworkUtil

class NetworkReceiver(private val listener: NetworkStatusChangeListener) : BroadcastReceiver() {
    override fun onReceive(context: Context, p1: Intent?) {
        listener.onNetworkStatusChanged(NetworkUtil.isNetworkAvailable(context))
    }
}