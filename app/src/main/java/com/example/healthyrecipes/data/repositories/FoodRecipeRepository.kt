package com.example.healthyrecipes.data.repositories

import com.example.healthyrecipes.data.sources.local.LocalDataSource
import com.example.healthyrecipes.data.sources.remote.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject



@ActivityRetainedScoped
class FoodRecipeRepository @Inject constructor(
    remoteDataSource: RemoteDataSource,
    localDataSource: LocalDataSource
) {
    val remote = remoteDataSource
    val local = localDataSource

}