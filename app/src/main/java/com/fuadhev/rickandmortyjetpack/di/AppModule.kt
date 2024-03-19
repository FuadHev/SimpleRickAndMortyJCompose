package com.fuadhev.rickandmortyjetpack.di

import com.fuadhev.rickandmortyjetpack.data.remote.api.CharacterApiService
import com.fuadhev.rickandmortyjetpack.data.repo.CharacterRepositoryImpl
import com.fuadhev.rickandmortyjetpack.domain.repo.CharacterRepository
import com.fuadhev.rickandmortyjetpack.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCharacterApiService():CharacterApiService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharacterApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(api:CharacterApiService):CharacterRepository{
        return CharacterRepositoryImpl(characterApi=api)
    }
}