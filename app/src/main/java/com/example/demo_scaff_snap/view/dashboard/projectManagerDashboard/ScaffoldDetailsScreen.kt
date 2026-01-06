package com.example.demo_scaff_snap.view.dashboard.projectManagerDashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.demo_scaff_snap.R
import com.example.demo_scaff_snap.utils.FontUtils
import org.checkerframework.checker.units.qual.mPERs

@Preview(showBackground = true)
@Composable
fun ScaffoldDetailsScreen() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (clMain, tvTitle, icScan, etSearch, tvPriority, tvTag, tvChange,
            tvDetails, tvPM) = createRefs()

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
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_icon),
                contentDescription = "Menu Icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier.constrainAs(icScan) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start, margin = (16.dp))
                    centerVerticallyTo(parent)
                }
            )

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
                }
            )
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
                },
            elevation = CardDefaults.cardElevation(
                defaultElevation = 1.dp
            )
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Box(
                    modifier = Modifier
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

                Box(
                    modifier = Modifier
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
                        top.linkTo(tvDetails.bottom, margin = 8.dp)
                        start.linkTo(tvDetails.start)
                    })
            }
        }

    }
}