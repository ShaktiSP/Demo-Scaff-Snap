package com.example.demo_scaff_snap.view.authScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.demo_scaff_snap.R
import com.example.demo_scaff_snap.dataStore.PrefKeys
import com.example.demo_scaff_snap.dataStore.PreferenceDataStoreModule
import com.example.demo_scaff_snap.view.Screen
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(navController: NavController) {

    val context = LocalContext.current
    val store =  remember { PreferenceDataStoreModule(context) }
    val scope = rememberCoroutineScope()

    Image(
        painter = painterResource(id = R.drawable.onboarding_splash),
        contentDescription = "btby Logo",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier
            .shadow(2.dp)
            .padding(bottom = 50.dp)
            .background(color = Color.Transparent)
            .windowInsetsPadding(WindowInsets.systemBars),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 50.dp)
                .windowInsetsPadding(WindowInsets.systemBars),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                onClick = {
                    scope.launch {
                        store.putPreference(
                            PrefKeys.IS_ONBOARDING_LOGIN,
                            true
                        )
                    }
                    navController.navigate(Screen.RoleSelectionScreen.route) {
                        popUpTo(Screen.Onboarding.route) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .width(200.dp) // or fillMaxWidth(0.5f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                )
            ) {
                Text(
                    text = "Get Started",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
        }
    }

}
