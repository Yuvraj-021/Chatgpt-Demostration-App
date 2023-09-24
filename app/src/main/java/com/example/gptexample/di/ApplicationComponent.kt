package com.example.gptexample.di

import com.example.gptexample.ChatApplication
import com.example.gptexample.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}