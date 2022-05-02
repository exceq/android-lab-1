package com.example.android_lab_1.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_lab_1.MainActivity
import com.example.android_lab_1.domain.api.MockApiService
import com.example.android_lab_1.domain.repository.MockRepository
import com.example.android_lab_1.domain.repository.MockRepositoryImpl
import com.example.android_lab_1.domain.usecases.*
import com.example.android_lab_1.ui.MainFragment
import com.example.android_lab_1.ui.MainViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mainViewModel(viewModel: MainViewModel): ViewModel
}

@Module
class NetworkModule {

    @Provides
    fun provideMockService(): MockApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://61f5894b62f1e300173c41ba.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create()
    }
}

@Module
interface AppBindModule {

    @Binds
    fun bindMockRepositoryImplToMockRepository(
        mockRepositoryImpl: MockRepositoryImpl
    ): MockRepository

    @Binds
    fun bindGetBalanceListUseCase(useCase: GetBalanceListUseCaseImpl): GetBalanceListUseCase

    @Binds
    fun bindGetUserInfoDataListUseCase(useCase: GetUserInfoDataDataListUseCaseImpl): GetUserInfoDataListUseCase

    @Binds
    fun bindGetTariffsListUseCase(useCase: GetTariffListUseCaseImpl): GetTariffListUseCase
}
