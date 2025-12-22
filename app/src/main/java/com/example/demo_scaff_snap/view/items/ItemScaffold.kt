package com.example.demo_scaff_snap.view.items

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.demo_scaff_snap.R
import com.example.demo_scaff_snap.utils.FontUtils

@Preview(showBackground = true)
@Composable
fun ItemScaffold() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {
            val (view, scaffoldID, tvTag, scaffoldName, locationIcon, location, tvNavigate, dashLine, status, priority, tvStatusName, tvPriority) = createRefs()

            Box(modifier = Modifier
                .width(4.dp)
                .height(40.dp)
                .constrainAs(view) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color(0xFFFDB001), Color(0xFFD66801)
                        )
                    ), shape = RoundedCornerShape(4.dp)
                ))

            Text(
                text = "SCF-SC-2025-001",
                fontFamily = FontUtils.poppinsSemiBold,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.constrainAs(scaffoldID) {
                        top.linkTo(view.top)
                        start.linkTo(view.end, margin = 8.dp)
                        end.linkTo(tvTag.start)
                        bottom.linkTo(view.bottom)
                        width = Dimension.fillToConstraints
                    })

            Box(modifier = Modifier
                .constrainAs(tvTag) {
                    top.linkTo(scaffoldID.top)
                    bottom.linkTo(scaffoldID.bottom)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints   // 0dp width
                }
                .paint(
                    painter = painterResource(id = R.drawable.ic_green_rectangle),
                    contentScale = ContentScale.FillBounds
                )
                .padding(horizontal = 12.dp, vertical = 10.dp)) {
                Text(
                    text = "High",
                    fontFamily = FontUtils.poppinsMedium,
                    fontSize = 12.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Text(
                text = "Boiler Unit 3 Upgrade",
                fontFamily = FontUtils.poppinsSemiBold,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.constrainAs(scaffoldName) {
                    top.linkTo(view.bottom, margin = 8.dp)
                    start.linkTo(view.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                })

            Image(
                painter = painterResource(R.drawable.ic_location),
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .constrainAs(locationIcon) {
                        top.linkTo(location.top)
                        start.linkTo(view.start)
                        end.linkTo(location.start)
                    })

            Text(
                text = "Boiler Unit 3 Upgrade",
                fontFamily = FontUtils.poppinsRegular,
                fontSize = 12.sp,
                color = Color(0xFF666666),
                modifier = Modifier.constrainAs(location) {
                    top.linkTo(scaffoldName.bottom, margin = 8.dp)
                    start.linkTo(locationIcon.end, margin = 4.dp)
                })

            Text(
                text = "Navigate",
                fontFamily = FontUtils.poppinsRegular,
                fontSize = 12.sp,
                color = Color(0xFF007AFF),
                modifier = Modifier.constrainAs(tvNavigate) {
                    top.linkTo(scaffoldName.bottom, margin = 8.dp)
                    end.linkTo(parent.end)
                })

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .constrainAs(dashLine) {
                        top.linkTo(location.bottom, margin = 12.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawLine(
                        color = Color.Gray,
                        start = Offset(x = 0f, y = size.height / 2),
                        end = Offset(x = size.width, y = size.height / 2),
                        strokeWidth = size.height,
                        pathEffect = PathEffect.dashPathEffect(
                            floatArrayOf(10f, 10f), 0f
                        )
                    )
                }
            }

            Text(
                text = "Status",
                fontFamily = FontUtils.poppinsRegular,
                fontSize = 12.sp,
                color = Color(0xFF666666),
                modifier = Modifier.constrainAs(status) {
                    top.linkTo(dashLine.bottom, margin = 8.dp)
                    start.linkTo(tvStatusName.start)
                })

            Text(
                text = "Priority",
                fontFamily = FontUtils.poppinsRegular,
                fontSize = 12.sp,
                color = Color(0xFF666666),
                modifier = Modifier.constrainAs(priority) {
                    bottom.linkTo(tvPriority.top)
                    start.linkTo(tvPriority.start)
                })

            Box(modifier = Modifier
                .constrainAs(tvStatusName) {
                    top.linkTo(status.bottom, margin = 2.dp)
                    start.linkTo(dashLine.start)
                    end.linkTo(tvPriority.start)
                    width = Dimension.fillToConstraints   // 0dp width
                }
                .background(
                    color = Color(0xFFEFEFEF), shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 12.dp, vertical = 10.dp)) {
                Text(
                    text = "Status",
                    fontFamily = FontUtils.poppinsMedium,
                    fontSize = 12.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Box(modifier = Modifier
                .constrainAs(tvPriority) {
                    top.linkTo(status.bottom, margin = 2.dp)
                    start.linkTo(tvStatusName.end, margin = 6.dp)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints   // 0dp width
                }
                .background(
                    color = Color(0xFFEFEFEF), shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 12.dp, vertical = 10.dp)) {
                Text(
                    text = "Status",
                    fontFamily = FontUtils.poppinsMedium,
                    fontSize = 12.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

        }
    }
}