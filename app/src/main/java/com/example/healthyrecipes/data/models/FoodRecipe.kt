package com.example.healthyrecipes.data.models

import com.google.gson.annotations.SerializedName




data class FoodRecipe(
    @SerializedName("results")
    val results: List<FoodResult>

)
