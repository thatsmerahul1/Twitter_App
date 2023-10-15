package com.rahul.twitterapp.view

import android.content.BroadcastReceiver
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.rahul.twitterapp.R
import com.rahul.twitterapp.listeners.NetworkStatusChangeListener
import com.rahul.twitterapp.receivers.NetworkReceiver
import com.rahul.twitterapp.utils.NetworkUtil

open class BaseActivity: AppCompatActivity(), NetworkStatusChangeListener {
    private lateinit var networkReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupActionBar(supportActionBar)
    }
    override fun onStart() {
        super.onStart()
        networkReceiver = NetworkReceiver(this)
        NetworkUtil.initNetworkReceiver(this, networkReceiver)
    }

    override fun onStop() {
        NetworkUtil.unregisterNetworkReceiver(this, networkReceiver)
        super.onStop()
    }

    override fun onNetworkStatusChanged(isNetworkAvailable: Boolean) {
        val networkStatusText = if (isNetworkAvailable) getString(R.string.network_available_now) else getString(R.string.network_not_available)
        showToast(networkStatusText)
    }

    open fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    private fun setupActionBar(supportActionBar: ActionBar?) {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setCustomView(R.layout.actionbar_custom_view)
        supportActionBar?.setDisplayShowCustomEnabled(true)
    }
}
