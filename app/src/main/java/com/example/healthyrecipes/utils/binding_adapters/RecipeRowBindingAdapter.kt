package com.example.healthyrecipes.utils.binding_adapters

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import coil.load
import com.example.healthyrecipes.R
import com.example.healthyrecipes.data.models.FoodResult
import com.example.healthyrecipes.ui.fragments.recipes.RecipesFragmentDirections
import org.jsoup.Jsoup



class RecipeRowBindingAdapter {

    companion object {
        const val TAG = "RecipeBinding"


        @BindingAdapter("app:veganColor")
        @JvmStatic
        fun applyVeganColor(view: View, vegan: Boolean) {

            if (vegan) {
                when (view) {
                    is TextView -> {
                        view.run {
                            setTextColor(
                                ContextCompat.getColor(context, R.color.green)
                            )
                        }
                    }
                    is ImageView -> {
                        view.run {
                            setColorFilter(
                                ContextCompat.getColor(context, R.color.green)
                            )
                        }
                    }
                }
            }
        }

        @BindingAdapter("app:loadImage")
        @JvmStatic
        fun loadImageFromUrl(imageView: ImageView, imageUrl: String) {
            imageView.load(imageUrl) {
                crossfade(600)
                error(R.drawable.ic_error)
            }
        }

        @BindingAdapter("app:setOnClickListener")
        @JvmStatic
        fun setOnClickListener(view: ConstraintLayout, foodResult: FoodResult) {
            view.setOnClickListener {
                try {
                    val action =
                        RecipesFragmentDirections.actionRecipesFragmentToDetailsActivity(foodResult)
                    view.findNavController().navigate(action)
                } catch (e: Exception) {
                    Log.e(TAG, "setOnClickListener: ", e)
                }
            }
        }

        @BindingAdapter("app:parseHtml")
        @JvmStatic
        fun parseHtml(textView: TextView, description: String?) {
            if (description != null) {
                val desc = Jsoup.parse(description).text()
                textView.text = desc
            }

        }


    }


}