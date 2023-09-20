package com.example.samplecryptoapp.data.remote

import com.example.samplecryptoapp.data.remote.dto.CoinDetailDTO
import com.example.samplecryptoapp.data.remote.dto.CoinListDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPi {

    @GET("coins")
    suspend fun getCoinList(): List<CoinListDTO>

    @GET("coins/{coinId")
    suspend fun getCoinById(
        @Path("coinId") coinId: String
    ): CoinDetailDTO
}