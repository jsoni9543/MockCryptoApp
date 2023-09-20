package com.example.samplecryptoapp.domain.repository

import com.example.samplecryptoapp.data.remote.dto.CoinDetailDTO
import com.example.samplecryptoapp.data.remote.dto.CoinListDTO

interface CoinPaprikaRepository {

    suspend fun getCoinList(): List<CoinListDTO>

    suspend fun getCoinById(coinId: String): CoinDetailDTO
}