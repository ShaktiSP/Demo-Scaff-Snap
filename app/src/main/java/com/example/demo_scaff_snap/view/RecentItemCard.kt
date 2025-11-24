package com.example.demo_scaff_snap.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.demo_scaff_snap.R

@Preview(showBackground = true)
@Composable
fun RecentItemCard() {

    ConstraintLayout(modifier = Modifier.fillMaxWidth().wrapContentHeight()){
        Box(modifier = Modifier
            .paint(
                painter = painterResource(id = R.drawable.et_backgrund_white),
                contentScale = ContentScale.FillBounds
            )
        ) {

        }
    }
}