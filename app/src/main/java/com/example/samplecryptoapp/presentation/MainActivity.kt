package com.example.samplecryptoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.samplecryptoapp.presentation.coinDetailInformation.CoinDetailInfromationScreen
import com.example.samplecryptoapp.presentation.coinListItem.CoinListScreen
import com.example.samplecryptoapp.presentation.ui.theme.SampleCryptoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleCryptoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavigationScreen.CoinListScreen.route
                    ) {
                        composable(
                            route = NavigationScreen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController = navController)
                        }

                        composable(
                            route = NavigationScreen.CoinDetailInformationScreen.route + "/{coinId}"
                        ) {
                            CoinDetailInfromationScreen()
                        }
                    }
                }
            }
        }
    }
}