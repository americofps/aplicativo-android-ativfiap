package br.com.fiap.recicheck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.recicheck.screens.HomeScreen
import br.com.fiap.recicheck.screens.LoadingScreen
import br.com.fiap.recicheck.screens.resultScreen
import br.com.fiap.recicheck.ui.theme.RecicheckTheme
import br.com.fiap.recicheck.viewModel.CoordenadasScreanViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecicheckTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ){
                        composable(route = "home"){ HomeScreen(navController)}
                        composable(route = "load"){ LoadingScreen(navController)}
                        composable(route = "result"){ resultScreen(navController, viewModel = CoordenadasScreanViewModel())}
                    }
                }
            }
        }
    }
}
