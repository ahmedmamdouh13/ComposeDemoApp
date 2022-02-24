package com.ahmedmamdouh13.ama.qurbacomposedemo.ui

import androidx.compose.runtime.Composable
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.toDisplayableCount

@Composable
fun Home(){
val mil : Long = 100000
val k : Long = 100
val mila : Long = 99999
val ka : Long = 9954
    println(mil.toDisplayableCount())
    println(mila.toDisplayableCount())
    println(k.toDisplayableCount())
    println(ka.toDisplayableCount())
}