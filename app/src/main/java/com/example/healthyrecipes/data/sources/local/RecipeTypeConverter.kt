package com.example.healthyrecipes.data.sources.local

import androidx.room.TypeConverter
import com.example.healthyrecipes.data.models.FoodRecipe
import com.example.healthyrecipes.data.models.FoodResult
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



class RecipeTypeConverter {

    var gson = Gson()

    @TypeConverter
    fun fromFoodRecipe(foodRecipe: FoodRecipe): String {
        val type = object : TypeToken<FoodRecipe>() {}.type
        return gson.toJson(foodRecipe, type)

    }

    @TypeConverter
    fun toFoodRecipe(foodRecipe: String): FoodRecipe {
        val type = object : TypeToken<FoodRecipe>() {}.type
        return gson.fromJson(foodRecipe, type)
    }

    @TypeConverter
    fun fromFoodResult(foodResult: FoodResult): String {
        val type = object : TypeToken<FoodResult>() {}.type
        return gson.toJson(foodResult, type)

    }

    @TypeConverter
    fun toFoodResult(foodResult: String): FoodResult {
        val type = object : TypeToken<FoodResult>() {}.type
        return gson.fromJson(foodResult, type)
    }

}