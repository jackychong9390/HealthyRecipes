package com.example.healthyrecipes.data.models

import android.os.Parcelable
import com.example.healthyrecipes.utils.Constants.Companion.IMAGE_BASE_URL
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize



@Parcelize
data class ExtendedIngredient(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("consistency")
    val consistency: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("original")
    val original: String,
    @SerializedName("unit")
    val unit: String
) : Parcelable {
    fun getImageUrl(): String {
        return "$IMAGE_BASE_URL$image"
    }
}
