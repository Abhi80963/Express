package com.example.express

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.express.authenticationPages.LoginPage
import com.example.express.authenticationPages.SignUpPage
import com.example.express.ui.theme.ExpressTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpressTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        }
                    MyApp()
                    }

                }
            }
        }
    }
@Composable
fun MyApp() {
    val newsViewModel: NewsViewModel = viewModel()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = LoginScreen) {
        composable<LoginScreen> {
            LoginPage(newsViewModel, navController)
        }
        composable<SignUpScreen> {
            SignUpPage(newsViewModel, navController)
        }
        composable<HomePageScreen> {
            HomePage(newsViewModel, navController)
        }
        composable<NewsArticleScreen> {
            val args = it.toRoute<NewsArticleScreen>()
            NewsArticlePage(args.url)
        }
    }
}

