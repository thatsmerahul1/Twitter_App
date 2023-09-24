package com.rahul.twitterapp.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rahul.twitterapp.constants.AppConstants
import com.rahul.twitterapp.view.following.FollowingFragment
import com.rahul.twitterapp.view.foryou.HomeForYouFragment

class TabsAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = AppConstants.HOME_SCREEN_TAB_COUNT
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            AppConstants.TAB_INDEX_FOR_YOU -> HomeForYouFragment()
            AppConstants.TAB_INDEX_FOLLOWING -> FollowingFragment()
            else -> HomeForYouFragment()
        }
    }
}