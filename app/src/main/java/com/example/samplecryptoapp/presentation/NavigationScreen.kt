package com.example.samplecryptoapp.presentation

sealed class NavigationScreen (val route: String) {
    object CoinListScreen: NavigationScreen("coin_list_screen")
    object CoinDetailInformationScreen: NavigationScreen("coin_detail_information_screen")
}