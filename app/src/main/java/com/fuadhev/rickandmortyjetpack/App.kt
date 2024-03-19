package com.fuadhev.rickandmortyjetpack

import android.app.Application
import com.fuadhev.rickandmortyjetpack.utils.Constant.BASE_URL
import dagger.hilt.android.HiltAndroidApp
import okhttp3.OkHttpClient
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidApp
class App:Application() {
}