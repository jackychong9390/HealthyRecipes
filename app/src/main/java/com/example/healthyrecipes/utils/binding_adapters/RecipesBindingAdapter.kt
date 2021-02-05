package com.example.healthyrecipes.utils.binding_adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.example.healthyrecipes.data.entities.FoodRecipeEntity
import com.example.healthyrecipes.data.models.FoodRecipe
import com.example.healthyrecipes.utils.NetworkResult




class RecipesBindingAdapter {
    companion object {
        @BindingAdapter("app:readApiResponse", "app:readDatabase", requireAll = true)
        @JvmStatic
        fun errorImageViewVisibility(
            view: View,
            apiResponse: NetworkResult<FoodRecipe>?,
            database: List<FoodRecipeEntity>?
        ) {
            when (view) {
                is ImageView -> {
                    view.isVisible = apiResponse is NetworkResult.Error && database.isNullOrEmpty()
                }
                is TextView -> {
                    view.isVisible = apiResponse is NetworkResult.Error && database.isNullOrEmpty()
                    view.text = apiResponse?.message.toString()
                }
            }

        }
    }
}