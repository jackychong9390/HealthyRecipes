package com.example.healthyrecipes.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.healthyrecipes.data.models.FoodRecipe
import com.example.healthyrecipes.utils.Constants.Companion.RECIPE_TABLE



@Entity(tableName = RECIPE_TABLE)
class FoodRecipeEntity(
    var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}
