package com.example.healthyrecipes.modules

import android.content.Context
import androidx.room.Room
import com.example.healthyrecipes.data.sources.local.FoodRecipeDao
import com.example.healthyrecipes.data.sources.local.RecipeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import com.example.healthyrecipes.utils.Constants.Companion.DATABASE_NAME
import javax.inject.Singleton



@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(
        @ApplicationContext context: Context
    ): RecipeDatabase =
        Room.databaseBuilder(context, RecipeDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration().build()


    @Singleton
    @Provides
    fun provideDao(database: RecipeDatabase): FoodRecipeDao = database.dao()

}