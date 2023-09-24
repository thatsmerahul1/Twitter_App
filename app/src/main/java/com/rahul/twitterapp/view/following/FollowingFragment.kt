package com.rahul.twitterapp.view.following

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.twitterapp.adapter.TweetListAdapter
import com.rahul.twitterapp.data.model.TweetListDataClass
import com.rahul.twitterapp.databinding.FragmentFollowingBinding
import com.rahul.twitterapp.viewmodel.FollowingViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FollowingFragment : Fragment() {

    private var _binding: FragmentFollowingBinding? = null
    private val binding get() = _binding!!
    private lateinit var tweetListAdapter: TweetListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val followingViewModel = ViewModelProvider(this)[FollowingViewModel::class.java]
        _binding = FragmentFollowingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        tweetListAdapter = TweetListAdapter(requireContext(), TweetListDataClass())

        initRecyclerView()

        followingViewModel.getTweets()
        followingViewModel.tweets.observe(viewLifecycleOwner) { tweets ->
            tweetListAdapter.refreshRecyclerView(requireContext(), tweets)
            hideLoader()
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            onPullToRefresh(followingViewModel)
        }

        return root
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = tweetListAdapter
        }
    }

    private fun onPullToRefresh(followingViewModel: FollowingViewModel) {
        hideRecyclerView()
        showLoader()
        followingViewModel.getTweets()
        binding.swipeRefreshLayout.isRefreshing = false
    }

    private fun showLoader() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideLoader() {
        // Kept delay of 1 second just to show loader or else it was not showing the loader because of small data is getting fetched immediately
        lifecycleScope.launch {
            delay(1000)
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
        }
    }

    private fun hideRecyclerView() {
        binding.recyclerView.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}