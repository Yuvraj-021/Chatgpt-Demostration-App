package com.example.gptexample.di

import com.example.gptexample.Utils.Constants
import com.example.gptexample.retrofit.ChatApi
import com.example.gptexample.repository.ChatGPTRepository
import com.example.gptexample.viewmodel.ChatGPTViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
     fun providesRetrofit() : ChatApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ChatApi::class.java)
    }


    @Provides
    @Singleton
    fun provideChatGPTRepository(api: ChatApi): ChatGPTRepository {
        return ChatGPTRepository(api)
    }

    @Provides
    @Singleton
    fun provideChatGPTViewModel(repository: ChatGPTRepository): ChatGPTViewModel {
        return ChatGPTViewModel(repository)
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }
}