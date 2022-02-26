package com.ahmedmamdouh13.ama.qurbacomposedemo.util

import java.util.*

typealias Timestamp = Long


fun Timestamp.toDisplayableDateTime(): String {
    val value = (Calendar.getInstance().time.time) - this


    val seconds = value / 1000
    val minutes = seconds / 60
    val hours = minutes / 60
    val days = hours / 24
    val months = days / 30
    val years = months / 12
    val s = "s"

    return when {
        seconds in 1..59 -> "$seconds second${if (seconds > 1) s else ""} ago"
        minutes in 1..59 -> "$minutes minute${if (minutes > 1) s else ""} ago"
        hours in 1..23 -> "$hours hour${if (hours > 1) s else ""} ago"
        days == 1L -> "Yesterday"
        days in 2..29 -> "$days days ago"
        months in 1..11 -> "$months month${if (months > 1) s else ""} ago"
        else -> "$years year${if (years > 1) s else ""} ago"
    }

}
