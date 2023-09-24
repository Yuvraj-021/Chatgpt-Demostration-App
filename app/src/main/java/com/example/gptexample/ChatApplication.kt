package com.example.gptexample

import android.app.Application
import com.example.gptexample.di.ApplicationComponent
import com.example.gptexample.di.DaggerApplicationComponent
import dagger.Component

class ChatApplication:Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()

        applicationComponent= DaggerApplicationComponent.builder().build()
    }
}