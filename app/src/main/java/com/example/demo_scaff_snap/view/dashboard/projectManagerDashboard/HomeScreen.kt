package com.example.demo_scaff_snap.view.dashboard.projectManagerDashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.demo_scaff_snap.R
import com.example.demo_scaff_snap.view.UserProfileMenuDrawer
import com.example.demo_scaff_snap.view.items.ItemScaffold
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            UserProfileMenuDrawer(
                onClose = {
                    scope.launch {
                        drawerState.close()
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(10.dp)
            ) {
                val (profile, statsGrid, itemOne, itemTwo, itemThree, itemFour, tvQuickFilter, rvLC) = createRefs()

                // Profile Bar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .constrainAs(profile) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    // Menu Icon - Drawer khulne ke liye
                    Image(
                        painter = painterResource(id = R.drawable.ic_menue),
                        contentDescription = "Menu Icon",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            "Hi, John Carter",
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "Project Manager",
                            textAlign = TextAlign.Start,
                            color = Color.Gray
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Notifications, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Surface(
                            shape = CircleShape, color = Color(0xFFFEBD47)
                        ) {
                            Text("JC", modifier = Modifier.padding(8.dp))
                        }
                    }
                }

                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .constrainAs(statsGrid) {
                            top.linkTo(profile.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        })
                {
                    Box(
                        modifier = Modifier
                            .height(140.dp)
                            .paint(
                                painter = painterResource(id = R.drawable.ic_totall_scaffold),
                                contentScale = ContentScale.FillBounds
                            )
                            .padding(24.dp)
                            .constrainAs(itemOne) {
                                top.linkTo(parent.top)
                                end.linkTo(itemTwo.start)
                                start.linkTo(parent.start)
                                width = Dimension.fillToConstraints
                            }) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(top = 5.dp),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Top
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_scaff),
                                contentDescription = "Scaffold Icon",
                                modifier = Modifier.size(30.dp)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "34",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Total Scaffolds",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .height(140.dp)
                            .constrainAs(itemTwo) {
                                top.linkTo(itemOne.top)
                                start.linkTo(itemOne.end)
                                end.linkTo(parent.end)
                                width = Dimension.fillToConstraints
                            }
                            .paint(
                                painter = painterResource(id = R.drawable.ic_total_project),
                                contentScale = ContentScale.FillBounds
                            )
                            .padding(24.dp)) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(top = 5.dp),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Top
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_project),
                                contentDescription = "Project Icon",
                                modifier = Modifier.size(30.dp),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "34",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Total Projects",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .height(140.dp)
                            .constrainAs(itemThree) {
                                top.linkTo(itemOne.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(itemFour.start)
                                width = Dimension.fillToConstraints
                            }
                            .paint(
                                painter = painterResource(id = R.drawable.ic_pending_request),
                                contentScale = ContentScale.FillBounds
                            )
                            .padding(24.dp)) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(top = 5.dp),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Top
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_pending),
                                contentDescription = "Pending Icon",
                                modifier = Modifier.size(30.dp),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "34",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Pending Requests",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .height(140.dp)
                            .constrainAs(itemFour) {
                                top.linkTo(itemThree.top)
                                start.linkTo(itemThree.end)
                                end.linkTo(parent.end)
                                width = Dimension.fillToConstraints
                            }
                            .paint(
                                painter = painterResource(id = R.drawable.ic_active_scaffolds),
                                contentScale = ContentScale.FillBounds
                            )
                            .padding(24.dp)) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(top = 5.dp),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Top
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_active),
                                contentDescription = "Active Scaffold Icon",
                                modifier = Modifier.size(30.dp),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "34",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Active Scaffolds",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }

                Text(
                    text = "Recent Scaffolds",
                    modifier = Modifier
                        .padding(top = 16.dp, start = 10.dp)
                        .constrainAs(tvQuickFilter) {
                            top.linkTo(statsGrid.bottom)
                        },
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                LazyColumn(
                    modifier = Modifier.constrainAs(rvLC) {
                        top.linkTo(tvQuickFilter.bottom)
                        start.linkTo(tvQuickFilter.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        height = Dimension.fillToConstraints
                        width = Dimension.fillToConstraints
                    }) {
                    items(10) { index ->
                        ItemScaffold()
                    }
                }
            }
        }
    }
}