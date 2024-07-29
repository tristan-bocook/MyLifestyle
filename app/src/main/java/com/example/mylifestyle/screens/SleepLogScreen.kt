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
fun SleepLogScreen() {
    var dateInput by remember { mutableStateOf("") }
    var hoursInput by remember { mutableStateOf("") }
    var minutesInput by remember { mutableStateOf("") }
    var sleepLogs by remember { mutableStateOf(listOf<SleepLog>()) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = dateInput,
            onValueChange = { dateInput = it },
            label = { Text("Enter date (e.g., yyyy-MM-dd)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = hoursInput,
            onValueChange = { hoursInput = it },
            label = { Text("Enter hours of sleep") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = minutesInput,
            onValueChange = { minutesInput = it },
            label = { Text("Enter minutes of sleep") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val hours = hoursInput.toIntOrNull()
                val minutes = minutesInput.toIntOrNull()
                if (hours != null && minutes != null) {
                    sleepLogs = sleepLogs + SleepLog(dateInput, hours, minutes)
                    dateInput = ""
                    hoursInput = ""
                    minutesInput = ""
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Log Sleep")
        }
        Spacer(modifier = Modifier.height(16.dp))
        SleepLogList(sleepLogs)
    }
}

@Composable
fun SleepLogList(sleepLogs: List<SleepLog>) {
    Column {
        for (log in sleepLogs) {
            Text("${log.date}: ${log.hours}h ${log.minutes}min", style = MaterialTheme.typography.bodyLarge)
            HorizontalDivider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSleepLogScreen() {
    SleepLogScreen()
}
