package com.example.demo_scaff_snap.view.dashboard.projectManagerDashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import com.example.demo_scaff_snap.R
import com.example.demo_scaff_snap.utils.FontUtils
import com.example.demo_scaff_snap.view.FilterBottomSheet
import com.example.demo_scaff_snap.view.items.ItemScaffold

@Composable
fun ScaffoldLogScreen(navController: NavController) {

    var searchText by remember { mutableStateOf("") }

    var showFilter by remember { mutableStateOf(false) }

    val view = LocalView.current
    DisposableEffect(Unit) {
        val window = (view.context as? android.app.Activity)?.window
        window?.let {
            it.statusBarColor = Color(0xFFFDB001).toArgb()
            WindowCompat.getInsetsController(it, view).isAppearanceLightStatusBars = false
        }
        onDispose {
            window?.let {
                it.statusBarColor = Color.White.toArgb()
                WindowCompat.getInsetsController(it, view).isAppearanceLightStatusBars = true
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFFFDB001), Color(0xFFD66801))
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "SCAFFOLD LOG",
                textAlign = TextAlign.Center,
                fontFamily = FontUtils.poppinsSemiBold,
                fontSize = 14.sp,
                color = Color.White
            )

            Image(
                painter = painterResource(id = R.drawable.ic_bg_scan),
                contentDescription = "Scan Icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 16.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Card(
                modifier = Modifier.weight(1f),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    placeholder = { Text("Search Scaffold ID") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = { }),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ic_mage_filter),
                contentDescription = "Filter Icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier.clickable { showFilter = true }
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(10) {
                Box(modifier = Modifier.clickable {
                    navController.navigate("scaffold_details")
                }) {
                    ItemScaffold()
                }
            }
        }
    }

    if (showFilter) {
        FilterBottomSheet(
            onDismiss = { showFilter = false },
            onApply = { date, status, tag, priority ->

                showFilter = false
            }
        )
    }
}