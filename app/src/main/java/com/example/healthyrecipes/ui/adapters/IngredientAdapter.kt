package com.example.healthyrecipes.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.healthyrecipes.data.models.ExtendedIngredient
import com.example.healthyrecipes.databinding.IngredientsRowLayoutBinding
import com.example.healthyrecipes.utils.IngredientDiffUtil



class IngredientAdapter : RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder>() {


    private var ingredients = emptyList<ExtendedIngredient>()


    class IngredientViewHolder(private val binding: IngredientsRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ingredient: ExtendedIngredient) {
            binding.ingredient = ingredient
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): IngredientViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = IngredientsRowLayoutBinding.inflate(layoutInflater, parent, false)
                return IngredientViewHolder(binding)
            }
        }

    }

    fun setData(newData: List<ExtendedIngredient>) {
        val ingredientDiffUtil = IngredientDiffUtil(ingredients, newData)
        val diffUtilResult = DiffUtil.calculateDiff(ingredientDiffUtil)
        ingredients = newData
        diffUtilResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder =
        IngredientViewHolder.from(parent)

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) =
        holder.bind(ingredients[position])

    override fun getItemCount(): Int = ingredients.size
}