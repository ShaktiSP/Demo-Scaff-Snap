package com.example.demo_scaff_snap.view.authScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.demo_scaff_snap.R
import com.example.demo_scaff_snap.model.commpanyLogin.CompanyLogInRequest
import com.example.demo_scaff_snap.utils.FontUtils
import com.example.demo_scaff_snap.utils.Resource
import com.example.demo_scaff_snap.utils.isNetworkAvailable
import com.example.demo_scaff_snap.utils.isValidEmail
import com.example.demo_scaff_snap.viewModel.AuthViewModel

@Composable
fun RegisterYourCompanyScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel: AuthViewModel = hiltViewModel()
    val companyLoginState by viewModel.companyLoginState.collectAsState()

    val scrollState = rememberScrollState()

    var companyName by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .verticalScroll(scrollState)
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
                    }
            )

            Text(
                text = "REGISTER YOUR COMPANY",
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
                .fillMaxSize()
                .offset(y = (-20).dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Default Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(androidx.compose.foundation.shape.CircleShape)
                        .border(1.dp, Color.Gray, androidx.compose.foundation.shape.CircleShape)
                )
            }

            OutlinedTextField(
                value = companyName,
                onValueChange = { companyName = it },
                label = {
                    Text(
                        "Company Name", fontFamily = FontUtils.poppinsRegular, fontSize = 14.sp
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
                value = mobileNumber,
                onValueChange = { mobileNumber = it },
                label = {
                    Text(
                        "Mobile Number", fontFamily = FontUtils.poppinsRegular,
                        fontSize = 14.sp
                    )
                },
                textStyle = TextStyle(
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 14.sp, color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(
                        "Email", fontFamily = FontUtils.poppinsRegular,
                        fontSize = 14.sp
                    )
                },
                textStyle = TextStyle(
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 14.sp, color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )

            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                label = {
                    Text(
                        "Address", fontFamily = FontUtils.poppinsRegular,
                        fontSize = 14.sp
                    )
                },
                textStyle = TextStyle(
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 14.sp, color = Color.Black
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
                        "Create Password", fontFamily = FontUtils.poppinsRegular,
                        fontSize = 14.sp
                    )
                },
                textStyle = TextStyle(
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 14.sp, color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = {
                    Text(
                        "Confirm Password", fontFamily = FontUtils.poppinsRegular,
                        fontSize = 14.sp
                    )
                },
                textStyle = TextStyle(
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 14.sp, color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )

            Button(
                onClick = {
                    when {
                        companyName.isBlank() -> {
                            Toast.makeText(context, "Enter company name", Toast.LENGTH_SHORT).show()
                        }

                        mobileNumber.isBlank() -> {
                            Toast.makeText(context, "Enter mobile number", Toast.LENGTH_SHORT)
                                .show()
                        }

                        email.isBlank() -> {
                            Toast.makeText(context, "Enter Email", Toast.LENGTH_SHORT).show()
                        }

                        !isValidEmail(email) -> {
                            Toast.makeText(context, "Invalid Email Format", Toast.LENGTH_SHORT)
                                .show()
                        }

                        address.isBlank() -> {
                            Toast.makeText(context, "Enter company address", Toast.LENGTH_SHORT)
                                .show()
                        }

                        password.isBlank() -> {
                            Toast.makeText(context, "Enter password", Toast.LENGTH_SHORT).show()
                        }

                        confirmPassword.isBlank() -> {
                            Toast.makeText(context, "Enter confirm password", Toast.LENGTH_SHORT)
                                .show()
                        }

                        else -> {
                            viewModel.companyLogin(
                                CompanyLogInRequest(
                                    address,
                                    "+91",
                                    email,
                                    "",
                                    0.0,
                                    0.0,
                                    mobileNumber,
                                    companyName,
                                    password
                                )
                            )
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

        LaunchedEffect(companyLoginState) {
            when (companyLoginState) {
                is Resource.Success -> {
                    val response = companyLoginState as Resource.Success
                    if (response.code == 200) {
                        Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                    } else if (response.code == 400) {
                        Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                    }
                }

                is Resource.Error -> {
                    Toast.makeText(context, companyLoginState.message, Toast.LENGTH_SHORT).show()
                }

                is Resource.InternetError -> {
                    if (!isNetworkAvailable(context)) {
                        Toast.makeText(
                            context,
                            "Check your internet connection.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                else -> Unit
            }
        }
    }
}