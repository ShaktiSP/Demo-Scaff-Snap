package com.example.demo_scaff_snap.view.authScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.demo_scaff_snap.R
import com.example.demo_scaff_snap.model.login.LoginRequest
import com.example.demo_scaff_snap.utils.FontUtils
import com.example.demo_scaff_snap.utils.Resource
import com.example.demo_scaff_snap.utils.isNetworkAvailable
import com.example.demo_scaff_snap.utils.isValidEmail
import com.example.demo_scaff_snap.view.Screen
import com.example.demo_scaff_snap.viewModel.AuthViewModel

@Composable
fun LogInScreen(navController: NavController) {

    val context = LocalContext.current
    val viewModel: AuthViewModel = hiltViewModel()
    val loginState by viewModel.loginState.collectAsState()

    var companyID by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F6F6))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFFFDB001), Color(0xFFD66801))
                    )
                )
                .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.back_icon),
                contentDescription = "Back",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        navController.popBackStack()
                    })
            Text(
                text = "LOGIN",
                color = Color.White,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 30.dp),
                fontFamily = FontUtils.poppinsSemiBold,
                textAlign = TextAlign.Center
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .offset(y = (-20).dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.splash_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(150.dp)
                    .padding(top = 30.dp)
            )
            // Title
            Text(
                text = "LOGIN AS A Project Manager",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black,
                fontFamily = FontUtils.poppinsSemiBold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp)
            )

            Text(
                text = "Enter your credentials to continue",
                fontSize = 14.sp,
                color = colorResource(id = R.color.textColor),
                fontFamily = FontUtils.poppinsRegular,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            OutlinedTextField(
                value = companyID,
                onValueChange = { companyID = it },
                label = {
                    Text(
                        "Company ID", fontFamily = FontUtils.poppinsRegular, fontSize = 14.sp
                    )
                },
                textStyle = TextStyle(
                    fontFamily = FontUtils.poppinsRegular, fontSize = 14.sp, color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(
                        "Email", fontFamily = FontUtils.poppinsRegular, fontSize = 14.sp
                    )
                },
                textStyle = TextStyle(
                    fontFamily = FontUtils.poppinsRegular, fontSize = 14.sp, color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        "Password", fontFamily = FontUtils.poppinsRegular, fontSize = 14.sp
                    )
                },
                textStyle = TextStyle(
                    fontFamily = FontUtils.poppinsRegular, fontSize = 14.sp, color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )

            Text(
                text = "Forgot Password?",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = colorResource(id = R.color.customBlue),
                fontFamily = FontUtils.poppinsMedium,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 12.dp)
                    .clickable {
                        navController.navigate(Screen.ForgotPasswordScreen.route) {
                            popUpTo(Screen.SelectLogInTypeScreen.route) { inclusive = false }
                        }
                    })

            Button(
                onClick = {
                    when {
                        companyID.isBlank() -> {
                            Toast.makeText(context, "Enter Company ID", Toast.LENGTH_SHORT).show()
                        }
                        email.isBlank() -> {
                            Toast.makeText(context, "Enter Email", Toast.LENGTH_SHORT).show()
                        }
                        !isValidEmail(email) -> {
                            Toast.makeText(context, "Invalid Email Format", Toast.LENGTH_SHORT).show()
                        }
                        password.isBlank() -> {
                            Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            val request = LoginRequest(companyID, email, password, "PROJECT_MANAGER")
                            viewModel.login(request)
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(top = 50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                )
            ) {
                Text(
                    text = "SUBMIT", style = TextStyle(
                        fontSize = 14.sp, fontFamily = FontUtils.poppinsSemiBold
                    )
                )
            }
        }

        LaunchedEffect(loginState) {
            when (loginState) {
                is Resource.Success -> {
                    val response = loginState as Resource.Success
                    if (response.code == 200) {
                         navController.navigate(Screen.PmMainScreen.route) {
                            popUpTo(Screen.LogInScreen.route) { inclusive = true }
                        }
                        Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                    } else if (response.code == 400) {
                        Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                    }
                }

                is Resource.Error -> {
                    Toast.makeText(context, loginState.message, Toast.LENGTH_SHORT).show()
                }

                is Resource.InternetError -> {
                    if (!isNetworkAvailable(context)) {
                        Toast.makeText(context, "Check your internet connection.", Toast.LENGTH_SHORT).show()
                    }
                }
                else -> Unit
            }
        }
    }
}