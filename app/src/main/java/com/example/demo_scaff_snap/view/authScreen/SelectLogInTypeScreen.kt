package com.example.demo_scaff_snap.view.authScreen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import com.example.demo_scaff_snap.R
import com.example.demo_scaff_snap.utils.FontUtils
import com.example.demo_scaff_snap.view.Screen

/*@Preview(showBackground = true)*/
@Composable
fun SelectLogInTypeScreen(navController: NavController) {

    var selectedRole by remember { mutableStateOf("PM") }
    val context = LocalContext.current

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
                text = "LOGIN AS A TEAM MEMBER",
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
                text = "Please Select Your Role",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black,
                fontFamily = FontUtils.poppinsSemiBold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                // Company Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { selectedRole = "PM" },
                    shape = RoundedCornerShape(16.dp),
                    border = if (selectedRole == "PM") BorderStroke(
                        2.dp, Color(0xFFFF9800)
                    ) else null,
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.project_manager_icon),
                            contentDescription = "Company Icon",
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Project Manager",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontUtils.poppinsSemiBold,
                                color = Color.Black
                            )
                            Text(
                                text = "Approve requests and manage scaffold projects",
                                fontSize = 12.sp,
                                fontFamily = FontUtils.poppinsRegular,
                                color = colorResource(id = R.color.textColor)
                            )
                        }
                    }
                }

                // Team Member Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { selectedRole = "CP" },
                    shape = RoundedCornerShape(16.dp),
                    border = if (selectedRole == "CP") BorderStroke(
                        2.dp, Color(0xFFFF9800)
                    ) else null,
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.competent_person_icon),
                            contentDescription = "Company Icon",
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Competent Person",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontFamily = FontUtils.poppinsSemiBold,
                            )
                            Text(
                                text = "Create, inspect, and tag scaffolds",
                                fontSize = 12.sp,
                                fontFamily = FontUtils.poppinsRegular,
                                color = colorResource(id = R.color.textColor)
                            )
                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { selectedRole = "TM" },
                    shape = RoundedCornerShape(16.dp),
                    border = if (selectedRole == "TM") BorderStroke(
                        2.dp, Color(0xFFFF9800)
                    ) else null,
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.tradsman_icon),
                            contentDescription = "Company Icon",
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Tradesman",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontFamily = FontUtils.poppinsSemiBold,
                            )
                            Text(
                                text = "Request and view scaffold information",
                                fontSize = 12.sp,
                                fontFamily = FontUtils.poppinsRegular,
                                color = colorResource(id = R.color.textColor)
                            )
                        }
                    }
                }
            }

            Button(
                onClick = {
                    when (selectedRole) {
                        "PM" ->
                            navController.navigate(Screen.LogInScreen.route) {
                                popUpTo(Screen.SelectLogInTypeScreen.route) { inclusive = false }
                            }

                        "CP" ->
                            navController.navigate(Screen.LogInScreen.route) {
                                popUpTo(Screen.SelectLogInTypeScreen.route) { inclusive = false }
                            }

                        else ->
                            Toast.makeText(context, "Please select a role", Toast.LENGTH_SHORT)
                                .show()
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(top = 50.dp),
                shape = RoundedCornerShape(8.dp), // ⬅ square rounded corners
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                )
            ) {
                Text(
                    text = "CONTINUE", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontUtils.poppinsSemiBold,
                    )
                )
            }


        }
    }
}