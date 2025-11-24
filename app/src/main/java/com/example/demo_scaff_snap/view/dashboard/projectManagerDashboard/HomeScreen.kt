package com.example.demo_scaff_snap.view.dashboard.projectManagerDashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.demo_scaff_snap.R
import com.example.demo_scaff_snap.view.RecentItemCard

@Preview(showBackground = true)
@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .padding(10.dp)
    ) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(10.dp)
        ) {
            val (profile, statsGrid, itemOne, itemTwo, itemThree, itemFour, tvQuickFilter, tvPro, tvRS, clMain, clHigh, clRed, clMod, clPA, clPB, rvLC) = createRefs()

            // Profile Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(profile) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_menue),
                    contentDescription = "Menu Icon",
                    contentScale = ContentScale.Crop
                )

                Column(
                    horizontalAlignment = Alignment.Start,   // <-- Start alignment added
                ) {
                    Text("Hi, John Carter", fontWeight = FontWeight.Bold)
                    Text("Project Manager", color = Color.Gray)
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Notifications, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Surface(
                        shape = CircleShape,
                        color = Color(0xFFFEBD47)
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
                    }) {
                Box(
                    modifier = Modifier
                        .width(200.dp)
                        .height(140.dp)
                        .paint(
                            painter = painterResource(id = R.drawable.ic_totall_scaffold),
                            contentScale = ContentScale.FillBounds
                        )
                        .padding(18.dp)
                        .constrainAs(itemOne) {
                            top.linkTo(parent.top)
                            end.linkTo(itemTwo.start)
                            start.linkTo(parent.start)
                        }) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(top = 5.dp),
                        horizontalAlignment = Alignment.Start,       // Left side se start
                        verticalArrangement = Arrangement.Top        // <-- Here
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
                        .width(200.dp)
                        .height(140.dp)
                        .constrainAs(itemTwo) {
                            top.linkTo(itemOne.top)
                            start.linkTo(itemOne.end)
                            end.linkTo(parent.end)
                        }
                        .paint(
                            painter = painterResource(id = R.drawable.ic_total_project),
                            contentScale = ContentScale.FillBounds
                        )
                        .padding(18.dp)) {

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
                        .width(200.dp)
                        .height(140.dp)
                        .constrainAs(itemThree) {
                            top.linkTo(itemOne.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(itemFour.start)
                        }
                        .paint(
                            painter = painterResource(id = R.drawable.ic_pending_request),
                            contentScale = ContentScale.FillBounds
                        )
                        .padding(18.dp)) {

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
                        .width(200.dp)
                        .height(140.dp)
                        .constrainAs(itemFour) {
                            top.linkTo(itemThree.top)
                            start.linkTo(itemThree.end)
                            end.linkTo(parent.end)
                        }
                        .paint(
                            painter = painterResource(id = R.drawable.ic_active_scaffolds),
                            contentScale = ContentScale.FillBounds
                        )
                        .padding(18.dp)) {

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
                    .padding(top = 16.dp)
                    .constrainAs(tvQuickFilter) {
                        top.linkTo(statsGrid.bottom)
                    },
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}