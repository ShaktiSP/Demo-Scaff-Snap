package com.example.demo_scaff_snap.view.dashboard.projectManagerDashboard

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo_scaff_snap.R
import com.example.demo_scaff_snap.view.UserProfileMenuDrawer
import com.example.demo_scaff_snap.view.items.ItemScaffold
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var headerVisible by rememberSaveable { mutableStateOf(false) }
    var statsVisible by rememberSaveable { mutableStateOf(false) }
    var listVisible by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        if (!headerVisible) {
            headerVisible = true
            delay(150)
            statsVisible = true
            delay(200)
            listVisible = true
        }
    }

    val headerAlpha by animateFloatAsState(if (headerVisible) 1f else 0f, tween(100))
    val headerOffsetY by animateFloatAsState(
        if (headerVisible) 0f else -30f, tween(100, easing = EaseOutCubic)
    )

    val statsAlpha by animateFloatAsState(if (statsVisible) 1f else 0f, tween(150))
    val statsOffsetY by animateFloatAsState(
        if (statsVisible) 0f else 40f, tween(150, easing = EaseOutCubic)
    )

    val listAlpha by animateFloatAsState(if (listVisible) 1f else 0f, tween(100))
    val listOffsetY by animateFloatAsState(
        if (listVisible) 0f else 40f, tween(100, easing = EaseOutCubic)
    )

    ModalNavigationDrawer(
        drawerState = drawerState, drawerContent = {
            UserProfileMenuDrawer(
                onClose = { scope.launch { drawerState.close() } })
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 16.dp, bottom = 8.dp)
                    .offset(y = headerOffsetY.dp)
                    .alpha(headerAlpha),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_menue),
                    contentDescription = "Menu Icon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { scope.launch { drawerState.open() } })
                Spacer(modifier = Modifier.width(12.dp))
                Column(
                    modifier = Modifier.weight(1f), horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        "Hi, John Carter", textAlign = TextAlign.Start, fontWeight = FontWeight.Bold
                    )
                    Text("Project Manager", textAlign = TextAlign.Start, color = Color.Gray)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Notifications, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Surface(shape = CircleShape, color = Color(0xFFFEBD47)) {
                        Text("JC", modifier = Modifier.padding(8.dp))
                    }
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
                contentPadding = PaddingValues(bottom = 24.dp)
            ) {

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp)
                            .offset(y = statsOffsetY.dp)
                            .alpha(statsAlpha)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            StatCard(
                                modifier = Modifier.weight(1f),
                                backgroundRes = R.drawable.ic_totall_scaffold,
                                iconRes = R.drawable.ic_scaff,
                                iconDesc = "Scaffold Icon",
                                value = "34",
                                label = "Total Scaffolds"
                            )
                            StatCard(
                                modifier = Modifier.weight(1f),
                                backgroundRes = R.drawable.ic_total_project,
                                iconRes = R.drawable.ic_project,
                                iconDesc = "Project Icon",
                                value = "34",
                                label = "Total Projects"
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            StatCard(
                                modifier = Modifier.weight(1f),
                                backgroundRes = R.drawable.ic_pending_request,
                                iconRes = R.drawable.ic_pending,
                                iconDesc = "Pending Icon",
                                value = "34",
                                label = "Pending Requests"
                            )
                            StatCard(
                                modifier = Modifier.weight(1f),
                                backgroundRes = R.drawable.ic_active_scaffolds,
                                iconRes = R.drawable.ic_active,
                                iconDesc = "Active Scaffold Icon",
                                value = "34",
                                label = "Active Scaffolds"
                            )
                        }
                    }
                }

                item {
                    Text(
                        text = "Recent Scaffolds",
                        modifier = Modifier
                            .padding(top = 20.dp, start = 10.dp, bottom = 8.dp)
                            .alpha(listAlpha)
                            .offset(y = listOffsetY.dp),
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                items(count = 10) { index ->
                    val itemAlpha by animateFloatAsState(
                        targetValue = if (listVisible) 1f else 0f, animationSpec = tween(
                            durationMillis = 350, delayMillis = 80 * index, easing = EaseOutCubic
                        )
                    )
                    Box(modifier = Modifier.alpha(itemAlpha)) {
                        ItemScaffold()
                    }
                }
            }
        }
    }
}

@Composable
private fun StatCard(
    modifier: Modifier = Modifier,
    backgroundRes: Int,
    iconRes: Int,
    iconDesc: String,
    value: String,
    label: String
) {
    Box(
        modifier = modifier
            .height(140.dp)
            .paint(
                painter = painterResource(id = backgroundRes),
                contentScale = ContentScale.FillBounds
            )
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 5.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = iconDesc,
                modifier = Modifier.size(30.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = value, color = Color.Black, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label, color = Color.Black, fontSize = 14.sp, fontWeight = FontWeight.Medium
            )
        }
    }
}