package com.example.demo_scaff_snap.view.authScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.demo_scaff_snap.R
import com.example.demo_scaff_snap.dataStore.IPreferenceDataStoreAPI
import com.example.demo_scaff_snap.dataStore.PrefKeys
import com.example.demo_scaff_snap.dataStore.PreferenceDataStoreModule
import com.example.demo_scaff_snap.view.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    val context = LocalContext.current

    val store = remember { PreferenceDataStoreModule(context) }

    LaunchedEffect(Unit) {
        delay(1500)

        val isLoggedIn = store.getFirstPreference(PrefKeys.IS_LOGIN, false)
        val isOnBoardingLogin = store.getFirstPreference(PrefKeys.IS_ONBOARDING_LOGIN, false)

        if (isLoggedIn){
            navController.navigate(Screen.PmMainScreen.route) {
                popUpTo(Screen.Splash.route) { inclusive = true }
            }
        } else{
            if (isOnBoardingLogin) {
                navController.navigate(Screen.Onboarding.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            } else{
                navController.navigate(Screen.RoleSelectionScreen.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_logo),
            contentDescription = "SCAFF-SNAP",
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
        )
    }
}