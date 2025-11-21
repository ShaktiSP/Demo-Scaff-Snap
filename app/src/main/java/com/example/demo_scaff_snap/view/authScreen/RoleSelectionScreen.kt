package com.example.demo_scaff_snap.view.authScreen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.draw.shadow
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
fun RoleSelectionScreen(navController: NavController) {

    var selectedRole by remember { mutableStateOf("company") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .shadow(2.dp)
            .fillMaxSize()
            .background(color = Color.Transparent)
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_logo),
            contentDescription = "btby Logo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(top = 60.dp)
        )

        Text(
            text = "WELCOME TO SCAFF SNAPP!",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontUtils.poppinsSemiBold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        )

        Text(
            text = "Choose how you want to get started?",
            modifier = Modifier
                .fillMaxWidth(),
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontUtils.poppinsRegular,
                color = colorResource(id = R.color.textColor),
                textAlign = TextAlign.Center
            )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Company Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { selectedRole = "company" },
                shape = RoundedCornerShape(16.dp),
                border = if (selectedRole == "company") BorderStroke(
                    2.dp,
                    Color(0xFFFF9800)
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
                        painter = painterResource(id = R.drawable.company_vision),
                        contentDescription = "Company Icon",
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Register Your Company!",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontUtils.poppinsSemiBold,
                            color = Color.Black,
                        )
                        Text(
                            text = "Create a company account to manage scaffold operations. Dashboard access available only via web.",
                            fontSize = 12.sp,
                            fontFamily = FontUtils.poppinsRegular,
                            color = colorResource(id = R.color.textColor),
                        )
                    }
                }
            }

            // Team Member Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { selectedRole = "member" },
                shape = RoundedCornerShape(16.dp),
                border = if (selectedRole == "member") BorderStroke(
                    2.dp,
                    Color(0xFFFF9800)
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
                        painter = painterResource(id = R.drawable.builder),
                        contentDescription = "Team Member Icon",
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Login As a Team Member!",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontUtils.poppinsSemiBold,
                            color = Color.Black
                        )
                        Text(
                            text = "Project managers, tradesmen, and staff can log in using the credentials provided by your company.",
                            fontSize = 12.sp,
                            fontFamily = FontUtils.poppinsRegular,
                            color = colorResource(id = R.color.textColor),
                        )
                    }
                }
            }
        }

        Button(
            onClick = {
                when (selectedRole) {
                    "company" ->
                        navController.navigate(Screen.RegisterYourCompanyScreen.route) {
                            popUpTo(Screen.RoleSelectionScreen.route) { inclusive = false }
                        }

                    "member" ->
                        navController.navigate(Screen.SelectLogInTypeScreen.route) {
                            popUpTo(Screen.RoleSelectionScreen.route) { inclusive = false }
                        }

                    else ->
                        Toast.makeText(context, "Please select a role", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .width(130.dp)
                .height(60.dp)
                .padding(top = 16.dp, end = 12.dp)
                .align(Alignment.End),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Next",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontUtils.poppinsSemiBold,
                    color = Color.White
                )
            )
        }
    }
}