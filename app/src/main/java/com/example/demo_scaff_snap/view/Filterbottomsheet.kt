package com.example.demo_scaff_snap.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Orange = Color(0xFFFDB001)
private val Black  = Color(0xFF1A1A1A)
private val White  = Color.White
private val BorderGray = Color(0xFFDDDDDD)

@Composable
private fun FilterChip(
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(50),
        color = if (selected) Orange else White,
        border = BorderStroke(
            width = 1.dp,
            color = if (selected) Orange else BorderGray
        )
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            color = if (selected) White else Black,
            fontSize = 13.sp,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        color = Black,
        modifier = Modifier.padding(bottom = 10.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBottomSheet(
    onDismiss: () -> Unit,
    onApply: (
        date: String,
        status: String,
        tag: String,
        priority: String
    ) -> Unit
) {
    var selectedDate     by remember { mutableStateOf("Newest First") }
    var selectedStatus   by remember { mutableStateOf("Pre-erection") }
    var selectedTag      by remember { mutableStateOf("Yellow") }
    var selectedPriority by remember { mutableStateOf("High") }

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        containerColor = White,
        dragHandle = null
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 24.dp, bottom = 32.dp)
        ) {
            // Title
            Text(
                text = "Filters & Sort",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Black,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            SectionTitle("Date")
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                listOf("Newest First", "Oldest First").forEach { option ->
                    FilterChip(
                        label = option,
                        selected = selectedDate == option,
                        onClick = { selectedDate = option }
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            SectionTitle("Statuses")
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                listOf("Pre-erection", "Erected", "Dismantled").forEach { option ->
                    FilterChip(
                        label = option,
                        selected = selectedStatus == option,
                        onClick = { selectedStatus = option }
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            SectionTitle("Tags")
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                listOf("Yellow", "Green", "Red").forEach { option ->
                    FilterChip(
                        label = option,
                        selected = selectedTag == option,
                        onClick = { selectedTag = option }
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            SectionTitle("Priorities")
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                listOf("High", "Medium", "Low").forEach { option ->
                    FilterChip(
                        label = option,
                        selected = selectedPriority == option,
                        onClick = { selectedPriority = option }
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Cancel
                OutlinedButton(
                    onClick = onDismiss,
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, BorderGray),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Black)
                ) {
                    Text(
                        "CANCEL",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }

                // Apply
                Button(
                    onClick = {
                        onApply(selectedDate, selectedStatus, selectedTag, selectedPriority)
                        onDismiss()
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Black)
                ) {
                    Text(
                        "APPLY FILTERS",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = White
                    )
                }
            }
        }
    }
}