package com.rahul.twitterapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.rahul.twitterapp.R
import com.rahul.twitterapp.constants.AppConstants
import com.rahul.twitterapp.data.model.TweetListDataClass
import com.rahul.twitterapp.utils.AppUtils

class TweetListAdapter (private var context: Context?, private var itemList: TweetListDataClass) :
    RecyclerView.Adapter<TweetListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDisplayName: AppCompatTextView = itemView.findViewById(R.id.tvDisplayName)
        val tvUserName: AppCompatTextView = itemView.findViewById(R.id.tvUserName)
        val tvDate: AppCompatTextView = itemView.findViewById(R.id.tvDate)
        val tvTweetMessage: AppCompatTextView = itemView.findViewById(R.id.tvTweetMessage)
        val tvReTweetCount: AppCompatTextView = itemView.findViewById(R.id.tvReTweetCount)
        val tvCommentCount: AppCompatTextView = itemView.findViewById(R.id.tvComment)
        val tvLikeCount: AppCompatTextView = itemView.findViewById(R.id.tvLike)
        val tvProfileReach: AppCompatTextView = itemView.findViewById(R.id.tvProfileReach)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        item.let {tweet ->
            holder.tvDisplayName.text = tweet.displayName
            holder.tvUserName.text = tweet.userName
            holder.tvDate.text = AppUtils.formatTimeInMillisToDateString(tweet.date.toLong(), AppConstants.DATE_FORMAT)
            holder.tvTweetMessage.text = tweet.message
            holder.tvReTweetCount.text = tweet.count.retweet.toString()
            holder.tvCommentCount.text = tweet.count.comment.toString()
            holder.tvLikeCount.text = tweet.count.likes.toString()
            holder.tvProfileReach.text = tweet.count.views.toString()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun refreshRecyclerView(mContext: Context, updatedItemList: TweetListDataClass) {
        context = mContext
        itemList = updatedItemList
        notifyDataSetChanged()
    }
}
