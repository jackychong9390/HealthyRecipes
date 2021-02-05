package com.example.healthyrecipes.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.healthyrecipes.data.models.FoodRecipe
import com.example.healthyrecipes.data.models.FoodResult
import com.example.healthyrecipes.databinding.RecipeRowLayoutBinding
import com.example.healthyrecipes.utils.RecipeDiffUtil



class FoodRecipeAdapter : RecyclerView.Adapter<FoodRecipeAdapter.FoodRecipeViewHolder>() {

    private var recipes = emptyList<FoodResult>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodRecipeViewHolder {
        return FoodRecipeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: FoodRecipeViewHolder, position: Int) {
        val currentRecipe = recipes[position]
        holder.bind(currentRecipe)

    }

    override fun getItemCount(): Int = recipes.size

    fun setData(newData: FoodRecipe) {
        val recipeDiffUtil = RecipeDiffUtil(recipes, newData.results)
        val diffUtilResult = DiffUtil.calculateDiff(recipeDiffUtil)
        recipes = newData.results
        diffUtilResult.dispatchUpdatesTo(this)
    }


    class FoodRecipeViewHolder(private val binding: RecipeRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(foodResult: FoodResult) {
            binding.foodResult = foodResult
            binding.executePendingBindings()
        }


        companion object {
            const val TAG = "RECIPE_ADAPTER"
            fun from(parent: ViewGroup): FoodRecipeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipeRowLayoutBinding.inflate(layoutInflater, parent, false)
                return FoodRecipeViewHolder(binding)
            }
        }
    }
}