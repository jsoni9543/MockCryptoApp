package com.example.samplecryptoapp.presentation.coinDetailInformation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplecryptoapp.common.Constants
import com.example.samplecryptoapp.common.Resource
import com.example.samplecryptoapp.domain.useCases.getCoinDetail.GetCoinDetailInformationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailInformationViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getCoinDetailInformationUseCase: GetCoinDetailInformationUseCase
): ViewModel() {

    private val _state = mutableStateOf(CoinDetailInformationState())
    val state: State<CoinDetailInformationState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoinDetailInformation(coinId)
        }
    }

    private fun getCoinDetailInformation(coinId: String){
        getCoinDetailInformationUseCase(coinId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinDetailInformationState(coinDetailInformation = result.data)
                }

                is Resource.Error -> {
                    _state.value = CoinDetailInformationState(error = result.message ?: "An Unexpected error Occurred")
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailInformationState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}