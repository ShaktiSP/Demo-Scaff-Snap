package com.example.demo_scaff_snap.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showBackground = true)
@Composable
fun RecentItemCard() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),

    ) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                val (tvScaffold, tvLocation, tvSts, tvStatus, tvCft, tvCraft, tvReq, tvRequester) = createRefs()

                Text(
                    modifier = Modifier
                        .constrainAs(tvScaffold) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                        .padding(top = 10.dp),
                    text = "Scaffold #SC-2025-001",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(modifier = Modifier
                    .constrainAs(tvLocation){
                        top.linkTo(tvScaffold.bottom)
                        start.linkTo(tvScaffold.start)
                    }
                    .padding(top = 10.dp),
                    text = "Scaffold #SC-2025-001",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Row(
                    modifier = Modifier
                        .constrainAs(tvSts) {
                            top.linkTo(tvLocation.bottom)
                            start.linkTo(tvLocation.start)
                        }
                        .padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                }
            }

        }
    }

}