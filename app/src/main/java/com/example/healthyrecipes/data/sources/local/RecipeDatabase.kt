package com.example.healthyrecipes.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.healthyrecipes.data.entities.FavoriteRecipeEntity
import com.example.healthyrecipes.data.entities.FoodRecipeEntity




@Database(
    entities = [FoodRecipeEntity::class, FavoriteRecipeEntity::class],
    version = 4,
    exportSchema = false

)
@TypeConverters(RecipeTypeConverter::class)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun dao(): FoodRecipeDao
}