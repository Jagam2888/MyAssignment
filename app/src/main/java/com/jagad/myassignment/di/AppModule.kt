package com.jagad.myassignment.di

import android.content.Context
import com.jagad.myassignment.network.RetrofitClientInstance
import com.jagad.myassignment.remote.APIEndPointInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Created by jagad on 9/18/2021
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideGetApi(
        @ApplicationContext context:Context,
        retrofitClientInstance: RetrofitClientInstance
    ):APIEndPointInterface{
        return retrofitClientInstance.buildApi(APIEndPointInterface::class.java,context)
    }
}