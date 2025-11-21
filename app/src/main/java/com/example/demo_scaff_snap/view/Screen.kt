package com.example.demo_scaff_snap.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demo_scaff_snap.view.authScreen.ForgotPasswordScreen
import com.example.demo_scaff_snap.view.authScreen.LogInScreen
import com.example.demo_scaff_snap.view.authScreen.OnboardingScreen
import com.example.demo_scaff_snap.view.authScreen.RegisterYourCompanyScreen
import com.example.demo_scaff_snap.view.authScreen.RoleSelectionScreen
import com.example.demo_scaff_snap.view.authScreen.SelectLogInTypeScreen
import com.example.demo_scaff_snap.view.authScreen.SplashScreen
import com.example.demo_scaff_snap.view.dashboard.projectManagerDashboard.PmMainScreen

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")
    object RoleSelectionScreen : Screen("roleSelectionScreen")
    object RegisterYourCompanyScreen : Screen("registerYourCompanyScreen")
    object SelectLogInTypeScreen : Screen("selectLogInTypeScreen")
    object LogInScreen : Screen("logInScreen")
    object ForgotPasswordScreen : Screen("forgotPasswordScreen")
    object PmMainScreen : Screen("pmMainScreen")
}

@Composable
fun AppNavHost(startDestination: String = Screen.Splash.route) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {

        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }

        composable(Screen.Onboarding.route) {
            OnboardingScreen(navController)
        }

        composable(Screen.RoleSelectionScreen.route) {
            RoleSelectionScreen(navController)
        }

        composable(Screen.RegisterYourCompanyScreen.route) {
            RegisterYourCompanyScreen(navController)
        }

        composable(Screen.SelectLogInTypeScreen.route) {
            SelectLogInTypeScreen(navController)
        }

        composable(Screen.LogInScreen.route) {
            LogInScreen(navController)
        }

        composable(Screen.ForgotPasswordScreen.route) {
            ForgotPasswordScreen(navController)
        }
        composable(Screen.PmMainScreen.route) {
            PmMainScreen()
        }

    }
}
