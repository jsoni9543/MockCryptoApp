package com.example.samplecryptoapp.presentation.coinDetailInformation

import com.example.samplecryptoapp.domain.model.CoinDetailInformation

data class CoinDetailInformationState(
    val isLoading: Boolean = false,
    val coinDetailInformation: CoinDetailInformation? = null,
    val error: String = ""
)
