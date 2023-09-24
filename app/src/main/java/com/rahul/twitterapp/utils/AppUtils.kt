package com.rahul.twitterapp.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object AppUtils {
    fun formatTimeInMillisToDateString(timeInMillis: Long, dateFormat: String): String {
        val dateFormatInstance = SimpleDateFormat(dateFormat, Locale.getDefault())
        val date = Date(timeInMillis)
        return dateFormatInstance.format(date)
    }
}