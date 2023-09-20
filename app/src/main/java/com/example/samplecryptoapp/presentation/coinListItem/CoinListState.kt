package com.example.samplecryptoapp.presentation.coinListItem

import com.example.samplecryptoapp.domain.model.CoinListItem

data class CoinListState(
    val isLoading: Boolean = false,
    val coinList: List<CoinListItem> = emptyList(),
    val error: String = ""
)