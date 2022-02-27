package com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.mapper

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.ahmedmamdouh13.ama.qurbacomposedemo.data.model.*
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.PostModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.comment.CommentModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.content.ContentType
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.content.PostContent
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.profile.PostProfileModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.profile.ProfileType
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.profile.SharedWithModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.promo.PromoModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.reaction.ReactionModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.reaction.ReactionType
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel.PostStates
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.Count

//Content type
const val TEXT = "TEXT"
const val IMAGE = "IMAGE"
const val PROMO = "PROMO"
const val SHARED_POST = "SHARED_POST"

//Reactions type
const val SHARE = "SHARE"
const val COMMENT = "COMMENT"
const val LIKE = "LIKE"

fun PostItem.toPostModel(postStates: PostStates) =

    PostModel(
        this.profile.toProfileModel(),
        this.content.map { it.toContentModel(postStates) },
        topComment = this.topComment.toCommentModel(
            postStates.topCommentLike,
            postStates.topCommentLikesCount,
            postStates.topCommentVisibility
        ),
        reactions = this.reactions.map {
            it.toReactionsModel(
                postStates.likesCount,
                postStates.like
            )
        }
    )


private fun Reaction.toReactionsModel(
    likesCount: ArrayList<MutableState<Count>>,
    like: ArrayList<MutableState<Boolean>>
): ReactionModel {

    val likesCountMutableState: MutableState<Count> = mutableStateOf(this.count)
    val isLikedMutableState: MutableState<Boolean> = mutableStateOf(this.isLiked)

    likesCount.add(likesCountMutableState)
    like.add(isLikedMutableState)
    val reactionType = when (this.type) {
        LIKE -> ReactionType.LIKE
        COMMENT -> ReactionType.COMMENT
        SHARE -> ReactionType.SHARE
        else -> ReactionType.LIKE
    }

    return ReactionModel(
        this.postId, type = reactionType,
        count = likesCountMutableState, isLiked = isLikedMutableState
    )

}

private fun TopComment.toCommentModel(
    topCommentLike: ArrayList<MutableState<Boolean>>,
    topCommentLikesCount: ArrayList<MutableState<Count>>,
    topCommentVisibility: ArrayList<MutableState<Boolean>>
): CommentModel {
    val likesCountMutableState = mutableStateOf(this.likesCount)
    val isLikedMutableState = mutableStateOf(this.isLiked)
    val isVisibleMutableState = mutableStateOf(this.isVisible)

    topCommentLikesCount.add(likesCountMutableState)
    topCommentLike.add(isLikedMutableState)
    topCommentVisibility.add(isVisibleMutableState)

    return CommentModel(
        this.commentId,
        this.postId,
        this.userName,
        this.profilePicUrl,
        likesCountMutableState,
        this.timestamp,
        this.commentText,
        isLikedMutableState,
        isVisibleMutableState,
    )
}

private fun Content.toContentModel(postStates: PostStates): PostContent =
    when (this.type) {
        TEXT -> PostContent(ContentType.TEXT, text = this.text)
        IMAGE -> PostContent(ContentType.IMAGE, images = this.images)
        PROMO -> PostContent(ContentType.PROMO, promo = this.promo.toPromoModel())
        SHARED_POST -> PostContent(
            ContentType.SHARED_POST,
            sharedPost = this.sharedPost.toPostModel(postStates)
        )
        else -> PostContent(ContentType.TEXT, text = this.text)
    }

private fun Promo.toPromoModel(): PromoModel =
    PromoModel(
        this.postId, this.vendorId, this.vendorPic,
        this.vendorPromoTitle,
        this.vendorPromoSubtitle,
        this.actionButtonText,
        this.isActionNeeded
    )

private fun Profile.toProfileModel() =
    PostProfileModel(
        this.postId,
        this.userId,
        this.userName,
        this.profilePicUrl,
        this.timestamp,
        getProfileType(this.profileType),
        this.sharedWith?.toSharedWithModel(),
        true
    )

private fun SharedWith.toSharedWithModel(): SharedWithModel =
    SharedWithModel(
        this.userId,
        this.postId,
        this.sharedWithName,
        getProfileType(this.profileType),
        this.isVerified
    )

private fun getProfileType(profileType: Int): ProfileType {
    return if (profileType == 0) ProfileType.BUYER
    else ProfileType.VENDOR
}
