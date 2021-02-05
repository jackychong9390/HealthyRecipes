package com.example.healthyrecipes.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.healthyrecipes.data.models.FoodResult
import com.example.healthyrecipes.utils.Constants.Companion.FAVORITE_RECIPE_TABLE



@Entity(tableName = FAVORITE_RECIPE_TABLE)
class FavoriteRecipeEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int, var foodResult: FoodResult
)