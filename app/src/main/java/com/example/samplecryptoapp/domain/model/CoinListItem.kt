package com.example.samplecryptoapp.domain.model

data class CoinListItem(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)
