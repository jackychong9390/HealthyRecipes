package com.example.healthyrecipes.data.sources.remote

import com.example.healthyrecipes.data.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject



class RemoteDataSource @Inject constructor(private val api: FoodRecipesApi) {

    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe> =
        api.getRecipes(queries)

    suspend fun searchRecipes(queries: Map<String, String>): Response<FoodRecipe> =
        api.searchRecipes(queries)

}