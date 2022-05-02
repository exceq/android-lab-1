package com.example.android_lab_1

import android.app.Application
import android.content.Context
import com.example.android_lab_1.di.AppComponent
import com.example.android_lab_1.di.DaggerAppComponent

class MainApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApplication -> appComponent
        else -> applicationContext.appComponent
    }