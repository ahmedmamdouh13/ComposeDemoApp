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

    return when {
        seconds in 1 .. 59 -> "$seconds seconds ago"
        minutes in 1 .. 59 -> "$minutes minutes ago"
        hours in 1 .. 23 -> "$hours hours ago"
        days in 1 .. 29 -> "$days days ago"
        months in 1 .. 11 -> "$months months ago"
        else -> "$years years ago"
    }

}
