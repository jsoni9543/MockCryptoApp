package com.example.samplecryptoapp.domain.useCases.getCoinList

import com.example.samplecryptoapp.common.Resource
import com.example.samplecryptoapp.data.remote.dto.toCoinListItem
import com.example.samplecryptoapp.domain.model.CoinListItem
import com.example.samplecryptoapp.domain.repository.CoinPaprikaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinListItemUseCase @Inject constructor(
    private val repository: CoinPaprikaRepository
) {

    operator fun invoke(): Flow<Resource<List<CoinListItem>>> = flow {
        try {
            emit(Resource.Loading<List<CoinListItem>>())
            val coinListItem = repository.getCoinList().map { it.toCoinListItem() }
            emit(Resource.Success<List<CoinListItem>>(coinListItem))
        } catch (e:HttpException) {
            emit(Resource.Error<List<CoinListItem>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException){
            emit(Resource.Error<List<CoinListItem>>("Couldn't reach server. Please check your internet connection!"))
        }
    }
}