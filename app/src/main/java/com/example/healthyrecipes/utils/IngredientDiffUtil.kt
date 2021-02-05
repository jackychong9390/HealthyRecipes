package com.example.healthyrecipes.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.healthyrecipes.data.models.ExtendedIngredient



class IngredientDiffUtil(
    private val oldList: List<ExtendedIngredient>,
    private val newList: List<ExtendedIngredient>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] === newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}