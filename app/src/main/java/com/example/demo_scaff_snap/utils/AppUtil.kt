package com.example.demo_scaff_snap.utils

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import androidx.annotation.RequiresPermission
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.demo_scaff_snap.R


object FontUtils {

    val poppinsLight = FontFamily(
        Font(R.font.poppins_light)
    )

    val poppinsItalic = FontFamily(
        Font(R.font.poppins_italic)
    )

    val poppinsRegular = FontFamily(
        Font(R.font.poppins_regular)
    )

    val poppinsMedium = FontFamily(
        Font(R.font.poppins_medium)
    )

    val poppinsSemiBold = FontFamily(
        Font(R.font.poppins_semibold)
    )

    val poppinsBold = FontFamily(
        Font(R.font.poppins_bold)
    )
}

fun isValidEmail(email: String): Boolean {
    val regex = Regex(
        "^(?!\\.)(?!.*\\.\\.)([A-Za-z0-9!#\$%&'*+/=?^_`{|}~-]+(\\.[A-Za-z0-9!#\$%&'*+/=?^_`{|}~-]+)*)" +
                "@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,}$"
    )
    return regex.matches(email)
}

@RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
fun isNetworkConnected(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    return cm!!.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
}


fun isNetworkAvailable(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return connectivityManager.activeNetworkInfo?.isConnectedOrConnecting == true
}

@Composable
fun DashedLine(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    strokeWidth: Dp = 2.dp,
    dashLength: Float = 10f,
    gapLength: Float = 10f
) {
    Canvas(modifier = modifier) {
        drawLine(
            color = color,
            start = Offset(0f, size.height / 2),
            end = Offset(size.width, size.height / 2),
            strokeWidth = strokeWidth.toPx(),
            pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(dashLength, gapLength),
                0f
            )
        )
    }
}