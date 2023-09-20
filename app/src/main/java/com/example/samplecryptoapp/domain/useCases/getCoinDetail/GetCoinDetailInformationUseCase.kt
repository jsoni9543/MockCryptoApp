package com.example.samplecryptoapp.domain.useCases.getCoinDetail

import com.example.samplecryptoapp.common.Resource
import com.example.samplecryptoapp.data.remote.dto.toCoinDetailInformation
import com.example.samplecryptoapp.domain.model.CoinDetailInformation
import com.example.samplecryptoapp.domain.repository.CoinPaprikaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailInformationUseCase @Inject constructor(
    private val repository: CoinPaprikaRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetailInformation>> = flow {
        try {
            emit(Resource.Loading<CoinDetailInformation>())
            val coinDetailInformation = repository.getCoinById(coinId).toCoinDetailInformation()
            emit(Resource.Success<CoinDetailInformation>(coinDetailInformation))
        } catch (e:HttpException) {
            emit(Resource.Error<CoinDetailInformation>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetailInformation>("Couldn't reach server. Please check your internet connection!"))
        }
    }
}