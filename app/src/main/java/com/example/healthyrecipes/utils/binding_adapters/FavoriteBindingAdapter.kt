package com.example.healthyrecipes.utils.binding_adapters

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.healthyrecipes.data.entities.FavoriteRecipeEntity
import com.example.healthyrecipes.ui.adapters.FavoriteRecipeAdapter



class FavoriteBindingAdapter {
    companion object {

        @BindingAdapter("app:setData", "app:adapter", requireAll = false)
        @JvmStatic
        fun setDataAndViewVisibility(
            view: View,
            favorites: List<FavoriteRecipeEntity>?,
            adapter: FavoriteRecipeAdapter?
        ) {


            if (favorites.isNullOrEmpty()) {

                view.run {
                    visibility = if (this is RecyclerView) {
                        View.GONE
                    } else {
                        View.VISIBLE
                    }
                }

            } else {
                view.run {
                    visibility = if (this is RecyclerView) {
                        adapter?.setData(favorites)
                        View.VISIBLE
                    } else {
                        View.GONE
                    }
                }

            }
        }

    }
}