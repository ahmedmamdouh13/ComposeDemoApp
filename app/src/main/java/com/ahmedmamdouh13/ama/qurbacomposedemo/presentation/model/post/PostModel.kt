package com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post

import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.comment.CommentModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.content.PostContent
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.profile.PostProfileModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.reaction.ReactionModel

data class PostModel(
    val profileModel: PostProfileModel,
    val content: List<PostContent>,
    val topComment: CommentModel,
    val reactions: List<ReactionModel>
)
