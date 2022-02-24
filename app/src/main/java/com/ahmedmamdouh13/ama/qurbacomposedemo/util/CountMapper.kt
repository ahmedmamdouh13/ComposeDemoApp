package com.ahmedmamdouh13.ama.qurbacomposedemo.util

import java.math.RoundingMode

const val mil = 1000000 // million
const val k = 1000 // thousand

fun Long.toDisplayableCount(): String {

    return when {
        this in 1000..999999 -> {
            if (this % k != 0L)
                "${getRoundedUp(this.toDouble() / k)}K"
            else "${this / k}K"
        }
        this > 999999 -> {
            if (this % mil != 0L)
                "${getRoundedUp(this.toDouble() / mil)}M"
            else "${this / mil}M"

        }
        else -> this.toString()
    }
}

private fun getRoundedUp(l: Double): Double {
    return l.toBigDecimal()
        .setScale(1, RoundingMode.FLOOR).toDouble()
}
