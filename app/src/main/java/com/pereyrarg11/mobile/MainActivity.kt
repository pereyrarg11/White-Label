package com.pereyrarg11.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pereyrarg11.mobile.core.presentation.navigation.ScreenRoute
import com.pereyrarg11.mobile.core.presentation.theme.WhiteLabelTheme
import com.pereyrarg11.mobile.feature.app_config.presentation.screen.AppConfigScreen
import com.pereyrarg11.mobile.feature.home.presentation.screen.HomeScreen
import com.pereyrarg11.mobile.feature.splash.presentation.screen.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            AppContent()
        }
    }
}

@Composable
fun AppContent(
    modifier: Modifier = Modifier,
) {
    WhiteLabelTheme {
        Surface(
            modifier = modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = ScreenRoute.Splash.route) {
                composable(ScreenRoute.Splash.route) {
                    SplashScreen(navController = navController)
                }
                composable(ScreenRoute.Home.route) {
                    HomeScreen()
                }
                composable(ScreenRoute.AppConfig.route) {
                    AppConfigScreen()
                }
            }
        }
    }
}
