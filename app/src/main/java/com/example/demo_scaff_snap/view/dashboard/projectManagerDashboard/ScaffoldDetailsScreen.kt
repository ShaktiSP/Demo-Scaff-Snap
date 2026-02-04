package com.example.demo_scaff_snap.view.dashboard.projectManagerDashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.demo_scaff_snap.R
import com.example.demo_scaff_snap.utils.DashedLine
import com.example.demo_scaff_snap.utils.FontUtils

@Preview(showBackground = true)
@Composable
fun ScaffoldDetailsScreen() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (clMain, tvTitle, icScan, etSearch, tvPriority, tvTag, tvChange, tvDetails, tvPM, ivOne, tvProjectManager, scaffold, tvScaffold) = createRefs()

        val (sd, ivSD, tvSD, ed, ivED, tvED, loc, ivLoc, tvLocation, dashLine, lr, ivLR, tvLR, tvSR) = createRefs()

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFFFDB001), Color(0xFFD66801))
                    )
                )
                .constrainAs(clMain) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }) {
            Image(
                painter = painterResource(id = R.drawable.back_icon),
                contentDescription = "Menu Icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier.constrainAs(icScan) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start, margin = (16.dp))
                    centerVerticallyTo(parent)
                })

            Text(
                text = "SCF-SC-2025-001",
                textAlign = TextAlign.Start,
                fontFamily = FontUtils.poppinsSemiBold,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier.constrainAs(tvTitle) {
                    top.linkTo(icScan.top)
                    bottom.linkTo(icScan.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .constrainAs(etSearch) {
                    top.linkTo(clMain.bottom)
                    start.linkTo(parent.start, margin = 10.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    width = Dimension.fillToConstraints
                }, elevation = CardDefaults.cardElevation(
                defaultElevation = 1.dp
            )
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Box(modifier = Modifier
                    .constrainAs(tvPriority) {
                        top.linkTo(parent.top, margin = 10.dp)
                        start.linkTo(parent.start, margin = 10.dp)
                    }
                    .background(
                        color = Color(0xFFF4EBFF), shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 10.dp)) {
                    Text(
                        text = "Medium",
                        fontFamily = FontUtils.poppinsMedium,
                        fontSize = 12.sp,
                        color = Color.Blue,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                Box(modifier = Modifier
                    .constrainAs(tvTag) {
                        top.linkTo(parent.top, margin = 10.dp)
                        end.linkTo(parent.end, margin = 10.dp)
                    }
                    .background(
                        color = Color(0xFFEFEFEF), shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 10.dp)) {
                    Text(
                        text = "Untagged",
                        fontFamily = FontUtils.poppinsMedium,
                        fontSize = 12.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                Text(
                    text = "Change Priority & Tag",
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 12.sp,
                    color = Color(0xFF007AFF),
                    modifier = Modifier.constrainAs(tvChange) {
                        top.linkTo(tvPriority.bottom, margin = 8.dp)
                        start.linkTo(tvPriority.start)
                    })

                Text(
                    text = "DETAILS",
                    fontFamily = FontUtils.poppinsSemiBold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.constrainAs(tvDetails) {
                        top.linkTo(tvChange.bottom, margin = 20.dp)
                        start.linkTo(tvPriority.start)
                    })

                Text(
                    text = "Project Name",
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 12.sp,
                    color = Color(0xFF666666),
                    modifier = Modifier.constrainAs(tvPM) {
                        top.linkTo(tvDetails.bottom, margin = 10.dp)
                        start.linkTo(tvDetails.start)
                    })

                Image(
                    painter = painterResource(R.drawable.ic_location),
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp)
                        .constrainAs(ivOne) {
                            top.linkTo(tvProjectManager.top)
                            start.linkTo(tvPM.start)
                            end.linkTo(tvProjectManager.start)
                        })

                Text(
                    text = "Boiler Unit 3 Upgrade",
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.constrainAs(tvProjectManager) {
                        top.linkTo(tvPM.bottom, margin = 8.dp)
                        start.linkTo(ivOne.end, margin = 4.dp)
                    })

                Text(
                    text = "Scaffold ID",
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 12.sp,
                    color = Color(0xFF666666),
                    modifier = Modifier.constrainAs(scaffold) {
                        top.linkTo(tvPM.top)
                        start.linkTo(tvPM.end)
                        end.linkTo(parent.end)
                    })
                Text(
                    text = "Boiler Unit 3 Upgrade",
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.constrainAs(tvScaffold) {
                        top.linkTo(tvPM.bottom, margin = 8.dp)
                        start.linkTo(scaffold.start)
                    })

                Text(
                    text = "Start Date",
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 12.sp,
                    color = Color(0xFF666666),
                    modifier = Modifier.constrainAs(sd) {
                        top.linkTo(tvProjectManager.bottom, margin = 10.dp)
                        start.linkTo(ivOne.start)
                    })

                Image(
                    painter = painterResource(R.drawable.ic_location),
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp)
                        .constrainAs(ivSD) {
                            top.linkTo(sd.bottom, margin = 8.dp)
                            start.linkTo(sd.start)
                        })

                Text(
                    text = "10 May 2025",
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.constrainAs(tvSD) {
                        start.linkTo(ivSD.end, margin = 4.dp)
                        top.linkTo(ivSD.top)
                        bottom.linkTo(ivSD.bottom)
                    })

                Text(
                    text = "End Date",
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 12.sp,
                    color = Color(0xFF666666),
                    modifier = Modifier.constrainAs(ed) {
                        top.linkTo(sd.top)
                        start.linkTo(scaffold.start)
                    })

                Image(
                    painter = painterResource(R.drawable.ic_location),
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp)
                        .constrainAs(ivED) {
                            top.linkTo(sd.bottom, margin = 8.dp)
                            start.linkTo(scaffold.start)
                        })

                Text(
                    text = "10 May 2025",
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.constrainAs(tvED) {
                        start.linkTo(ivED.end, margin = 4.dp)
                        top.linkTo(ivED.top)
                        bottom.linkTo(ivED.bottom)
                    })

                Text(
                    text = "Location",
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 12.sp,
                    color = Color(0xFF666666),
                    modifier = Modifier.constrainAs(loc) {
                        top.linkTo(tvSD.bottom, margin = 10.dp)
                        start.linkTo(ivSD.start)
                    })

                Image(
                    painter = painterResource(R.drawable.ic_location),
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp)
                        .constrainAs(ivLoc) {
                            top.linkTo(loc.bottom, margin = 8.dp)
                            start.linkTo(loc.start)
                        })

                Text(
                    text = "Boiler Unit 3 Upgrade",
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.constrainAs(tvLocation) {
                        start.linkTo(ivLoc.end, margin = 4.dp)
                        top.linkTo(ivLoc.top)
                        bottom.linkTo(ivLoc.bottom)
                    })

                DashedLine(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .constrainAs(dashLine) {
                            top.linkTo(tvLocation.bottom, margin = 10.dp)
                        }, color = Color.Gray
                )

                Text(
                    text = "Last Requested By",
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 12.sp,
                    color = Color(0xFF666666),
                    modifier = Modifier.constrainAs(lr) {
                        top.linkTo(dashLine.bottom, margin = 10.dp)
                        start.linkTo(ivSD.start)
                    })

                Image(
                    painter = painterResource(R.drawable.ic_location),
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp)
                        .constrainAs(ivLR) {
                            top.linkTo(lr.bottom, margin = 8.dp)
                            start.linkTo(lr.start)
                        })

                Text(
                    text = "Boiler Unit 3 Upgrade",
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.constrainAs(tvLR) {
                        start.linkTo(ivLR.end, margin = 4.dp)
                        top.linkTo(ivLR.top)
                        bottom.linkTo(ivLR.bottom)
                    })

                Text(
                    text = "Scaffold Requested",
                    fontFamily = FontUtils.poppinsRegular,
                    fontSize = 14.sp,
                    color = Color(0xFF2F60F9),
                    modifier = Modifier.constrainAs(tvSR) {
                        top.linkTo(lr.top)
                        start.linkTo(scaffold.start)
                    })

            }
        }
    }
}