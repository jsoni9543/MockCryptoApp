package com.example.samplecryptoapp.di

import com.example.samplecryptoapp.common.Constants
import com.example.samplecryptoapp.data.remote.CoinPaprikaAPi
import com.example.samplecryptoapp.data.repository.CoinPaprikaRepositoryImplementation
import com.example.samplecryptoapp.domain.repository.CoinPaprikaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinPaprikaAPi {
        return  Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaAPi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinPaprikaRepository(api: CoinPaprikaAPi): CoinPaprikaRepository {
        return CoinPaprikaRepositoryImplementation(api)
    }
}