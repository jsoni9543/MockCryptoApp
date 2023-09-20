package com.example.samplecryptoapp.data.repository

import com.example.samplecryptoapp.data.remote.CoinPaprikaAPi
import com.example.samplecryptoapp.data.remote.dto.CoinDetailDTO
import com.example.samplecryptoapp.data.remote.dto.CoinListDTO
import com.example.samplecryptoapp.domain.repository.CoinPaprikaRepository
import javax.inject.Inject

class CoinPaprikaRepositoryImplementation @Inject constructor(
    private val api: CoinPaprikaAPi
): CoinPaprikaRepository {
    override suspend fun getCoinList(): List<CoinListDTO> {
        return api.getCoinList()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDTO {
        return api.getCoinById(coinId)
    }
}