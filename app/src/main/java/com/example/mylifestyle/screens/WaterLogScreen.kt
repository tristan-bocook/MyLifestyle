package com.example.mylifestyle.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterLogScreen() {
    var dateInput by remember { mutableStateOf("") }
    var amountInput by remember { mutableStateOf("") }
    var waterLogs by remember { mutableStateOf(listOf<WaterLog>()) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = dateInput,
            onValueChange = { dateInput = it },
            label = { Text("Enter date (e.g., yyyy-MM-dd)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = amountInput,
            onValueChange = { amountInput = it },
            label = { Text("Enter water amount (ounces)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (amountInput.toIntOrNull() != null) {
                    waterLogs = waterLogs + WaterLog(dateInput, amountInput.toInt())
                    dateInput = "" // Reset inputs after logging
                    amountInput = ""
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally) // Corrected alignment
        ) {
            Text("Log Water")
        }

        Spacer(modifier = Modifier.height(16.dp))
        WaterLogList(waterLogs)
    }
}

@Composable
fun WaterLogList(waterLogs: List<WaterLog>) {
    Column {
        for (log in waterLogs) {
            Text("${log.date}: ${log.amount} ml", style = MaterialTheme.typography.bodyLarge)
            HorizontalDivider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWaterLogScreen() {
    WaterLogScreen()
}
