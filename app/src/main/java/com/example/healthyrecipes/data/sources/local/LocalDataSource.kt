package com.example.healthyrecipes.data.sources.local

import com.example.healthyrecipes.data.entities.FavoriteRecipeEntity
import com.example.healthyrecipes.data.entities.FoodRecipeEntity
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject



class LocalDataSource @Inject constructor(private val dao: FoodRecipeDao) {

    suspend fun insertFoodRecipes(foodRecipeEntity: FoodRecipeEntity) =
        dao.insertRecipes(foodRecipeEntity)

    fun readRecipes(): Flow<List<FoodRecipeEntity>> = dao.readRecipes()

    suspend fun insertFavoriteRecipes(favoriteRecipeEntity: FavoriteRecipeEntity) =
        dao.insertFavoriteRecipes(favoriteRecipeEntity)

    fun readFavoriteRecipes(): Flow<List<FavoriteRecipeEntity>> = dao.readFavoriteRecipes()

    suspend fun deleteFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity) =
        dao.deleteFavoriteRecipe(favoriteRecipeEntity)

    suspend fun deleteAllFavorites() = dao.deleteAllFavorites()




}