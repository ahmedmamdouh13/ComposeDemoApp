package com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmedmamdouh13.ama.qurbacomposedemo.data.PostsRepository
import com.ahmedmamdouh13.ama.qurbacomposedemo.data.Result
import com.ahmedmamdouh13.ama.qurbacomposedemo.data.model.Posts
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.mapper.toPostModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.PostModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.comment.CommentModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.promo.PromoModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.reaction.ReactionModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.reaction.ReactionType
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PostViewModel() : ViewModel() {

    private val repo: PostsRepository = PostsRepository()
    private val postStates: PostStates = PostStates()


    private val _postsLiveData: MutableLiveData<List<PostModel>> = MutableLiveData()
    val postsLiveData: LiveData<List<PostModel>> = _postsLiveData

    fun getAllPosts(context: Context) {
        viewModelScope.launch {
            repo.getAllPosts(context).collect { result ->
                when (result) {
                    is Result.Error -> Log.d(
                        "PostViewModel",
                        result.e.message.toString()
                    )
                    is Result.Success<*> ->
                        _postsLiveData.value =
                            (result.data as Posts).map { it.toPostModel(postStates) }
                }
            }

        }
    }

    fun onClickReaction(reaction: ReactionModel) {
        when (reaction.type) {
            ReactionType.LIKE -> {

                if (!reaction.isLiked.value) reaction.count.value = reaction.count.value + 1
                else reaction.count.value = reaction.count.value - 1

                reaction.isLiked.value = !reaction.isLiked.value
            }
            ReactionType.SHARE -> { }
            ReactionType.COMMENT -> { }
        }
    }

    fun onLikeComment(comment: CommentModel) {
        if (!comment.isLiked.value) comment.likesCount.value = comment.likesCount.value + 1
        else comment.likesCount.value = comment.likesCount.value - 1
        comment.isLiked.value = !comment.isLiked.value
    }

    fun onPromoActionClick(promoModel: PromoModel) {
        //
    }

    fun onMenuButtonClick() {
        //
    }


}

