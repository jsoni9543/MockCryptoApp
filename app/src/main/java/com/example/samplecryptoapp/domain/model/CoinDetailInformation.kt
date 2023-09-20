package com.example.samplecryptoapp.domain.model

import com.example.samplecryptoapp.data.remote.dto.Team

data class CoinDetailInformation(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<Team>
)
