package com.ahmedmamdouh13.ama.qurbacomposedemo.util

import java.math.RoundingMode

private const val bil = 1000000000 // billion
private const val mil = 1000000 // million
private const val k = 1000 // thousand

typealias Count = Long

fun Count.toDisplayableCount(): String {

    return when {
        this < 1 -> ""
        this in k until mil -> {
            if (this % k != 0L)
                "${getRoundedUp(this.toDouble() / k)}K"
            else "${this / k}K"
        }
        this in mil until bil -> {
            if (this % mil != 0L)
                "${getRoundedUp(this.toDouble() / mil)}M"
            else "${this / mil}M"

        }
        this >= bil -> {
            if (this % bil != 0L)
                "${getRoundedUp(this.toDouble() / bil)}B"
            else "${this / bil}B"
        }
        else -> this.toString()
    }
}

private fun getRoundedUp(l: Double): Double {
    return l.toBigDecimal()
        .setScale(1, RoundingMode.FLOOR).toDouble()
}
