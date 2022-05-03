package com.example.android_lab_1.di

import com.example.android_lab_1.MainActivity
import com.example.android_lab_1.ui.MainFragment
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)

    fun viewModelFactory(): ViewModelFactory
}

@Module(includes = [NetworkModule::class, AppBindModule::class, ViewModelModule::class])
class AppModule
