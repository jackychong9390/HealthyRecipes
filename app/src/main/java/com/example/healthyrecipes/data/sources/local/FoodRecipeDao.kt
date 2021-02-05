package com.example.healthyrecipes.data.sources.local

import androidx.room.*
import com.example.healthyrecipes.data.entities.FavoriteRecipeEntity
import com.example.healthyrecipes.data.entities.FoodRecipeEntity
import kotlinx.coroutines.flow.Flow




@Dao
interface FoodRecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipeEntity: FoodRecipeEntity)

    @Query("SELECT * FROM recipes ORDER BY id ASC")
    fun readRecipes(): Flow<List<FoodRecipeEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteRecipes(favoriteRecipeEntity: FavoriteRecipeEntity)


    @Query("SELECT * FROM favorites ORDER BY id ASC")
    fun readFavoriteRecipes(): Flow<List<FavoriteRecipeEntity>>


    @Delete
    suspend fun deleteFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity)

    @Query("DELETE  FROM favorites")
    suspend fun deleteAllFavorites()



}