package com.ahmedmamdouh13.ama.qurbacomposedemo.ui

import androidx.compose.runtime.Composable
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.ReactionModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.ReactionType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.Reaction
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.toDisplayableCount

@Composable
fun Home(){
    val displayableCount = (80000L).toDisplayableCount()
    val type = ReactionType.COMMENT
    Reaction(ReactionModel(displayableCount, type)){
        println(it.name + " here!!!")
    }

}