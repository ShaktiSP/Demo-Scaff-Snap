package com.example.demo_scaff_snap.view.dashboard.projectManagerDashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import com.example.demo_scaff_snap.utils.FontUtils
import com.example.demo_scaff_snap.view.items.ItemScaffold

@Preview(showBackground = true)
@Composable
fun ScaffoldLogScreen() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        val (clMain, tvTitle, ivFilter, rvLC) = createRefs()

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .background(Color.White)
                .background(
                    color = Color(0xFFFDB001)
                )
                .constrainAs(clMain) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_menue),
                contentDescription = "Menu Icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier.constrainAs(ivFilter) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end, margin = (16.dp))
                    centerVerticallyTo(parent)
                }
            )

            Text(
                text = "SCAFFOLD LOG",
                textAlign = TextAlign.Start,
                fontFamily = FontUtils.poppinsSemiBold,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier.constrainAs(tvTitle) {
                    top.linkTo(ivFilter.top)
                    bottom.linkTo(ivFilter.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
        }

        LazyColumn(
            modifier = Modifier
                .padding(10.dp)
                .constrainAs(rvLC) {
                    top.linkTo(clMain.bottom)
                    start.linkTo(parent.start)
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