package com.example.samplecryptoapp.data.remote.dto

import com.example.samplecryptoapp.domain.model.CoinListItem
import com.google.gson.annotations.SerializedName

data class CoinListDTO(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinListDTO.toCoinListItem(): CoinListItem {
    return CoinListItem(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}