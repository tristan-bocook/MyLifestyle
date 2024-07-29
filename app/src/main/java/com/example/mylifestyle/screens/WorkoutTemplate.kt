package com.example.mylifestyle.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class WorkoutEntry(
    var exercise: String,
    var sets: Int,
    var reps: String, // Changed from Int to String
    var time: String? = null
)

@Composable
fun WorkoutTemplate() {
    val tableData = remember { mutableStateListOf<WorkoutEntry>() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        TableScreen(
            tableData = tableData,
            onAddRow = { tableData.add(WorkoutEntry("", 0, "", "")) }
        )
    }
}

@Composable
fun TableCell(text: String, onTextChanged: (String) -> Unit, width: Dp) {
    var state by remember { mutableStateOf(text) }

    BasicTextField(
        value = state,
        onValueChange = {
            state = it
            onTextChanged(it)
        },
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center, fontSize = 14.sp),
        modifier = Modifier
            .width(width)
            .border(1.dp, Color.Black)
            .padding(8.dp)
            .background(Color.LightGray)
    )
}

@Composable
fun TableScreen(tableData: MutableList<WorkoutEntry>, onAddRow: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            HeaderRow()
        }
        items(items = tableData, key = { item -> item.hashCode() }) { entry ->
            WorkoutRow(entry)
        }
        item {
            Button(
                onClick = onAddRow,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Add Row")
            }
        }
    }
}

@Composable
fun HeaderRow() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .padding(8.dp)
    ) {
        Text("Exercise", modifier = Modifier.width(180.dp), textAlign = TextAlign.Center)
        Text("Sets", modifier = Modifier.width(50.dp), textAlign = TextAlign.Center)
        Text("Reps", modifier = Modifier.width(80.dp), textAlign = TextAlign.Center)
        Text("Time", modifier = Modifier.width(80.dp), textAlign = TextAlign.Center)
    }
}

@Composable
fun WorkoutRow(entry: WorkoutEntry) {
    Row(Modifier.fillMaxWidth().border(1.dp, Color.Black)) {
        TableCell(text = entry.exercise, onTextChanged = { newText ->
            entry.exercise = newText
        }, width = 180.dp)
        TableCell(text = entry.sets.toString(), onTextChanged = { newText ->
            entry.sets = newText.toIntOrNull() ?: entry.sets // Handle non-integer input gracefully
        }, width = 50.dp)
        TableCell(text = entry.reps, onTextChanged = { newText ->
            entry.reps = newText
        }, width = 80.dp)
        TableCell(text = entry.time ?: "", onTextChanged = { newText ->
            entry.time = newText
        }, width = 80.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun WorkoutScreenPreview() {
    MaterialTheme {
        WorkoutTemplate()
    }
}





/*package com.example.mylifestyle.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class WorkoutEntry(
    var exercise: String,
    var sets: Int,
    var reps: Int,
    var time: String? = null
)

@Composable
fun WorkoutTemplate() {
    val tableData = remember { mutableStateListOf<WorkoutEntry>() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        TableScreen(
            tableData = tableData,
            onAddRow = { tableData.add(WorkoutEntry("", 0, 0, "")) }
        )
    }
}

@Composable
fun TableCell(
    text: String,
    onTextChanged: (String) -> Unit
) {
    var state by remember { mutableStateOf(text) }

    BasicTextField(
        value = state,
        onValueChange = {
            state = it
            onTextChanged(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Black)
            .padding(8.dp) // Padding for the text field content
    )
}

@Composable
fun TableScreen(
    tableData: MutableList<WorkoutEntry>,
    onAddRow: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Row(Modifier.fillMaxWidth().background(Color.Gray).padding(8.dp)) {
                Text("com.example.mylifestyle.screens.Exercise", modifier = Modifier.weight(0.5f))
                Text("Sets", modifier = Modifier.weight(0.15f))
                Text("Reps", modifier = Modifier.weight(0.2f))
                Text("Time", modifier = Modifier.weight(0.2f))
            }
        }
        items(items = tableData, key = { item -> item.hashCode() }) { entry ->
            Row(Modifier.fillMaxWidth()) {
                TableCell(text = entry.exercise) { newText ->
                    entry.exercise = newText
                }
                TableCell(text = entry.sets.toString()) { newText ->
                    entry.sets = newText.toIntOrNull() ?: entry.sets
                }
                TableCell(text = entry.reps.toString()) { newText ->
                    entry.reps = newText.toIntOrNull() ?: entry.reps
                }
                TableCell(text = entry.time ?: "") { newText ->
                    entry.time = newText
                }
            }
        }
        item {
            Button(
                onClick = onAddRow,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Add Row")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WorkoutScreenPreview() {
    MaterialTheme {
        WorkoutTemplate()
    }
}*/
/*
package com.example.lifestyle_app.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class WorkoutEntry(
    var exercise: String,
    var sets: Int,
    var reps: Int,
    var time: String? = null
)

@SuppressLint("ResourceType")
@Composable
fun WorkoutTemplate() {
    val tableData = remember { mutableStateListOf<WorkoutEntry>() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Workout",
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.Black // Ensure text color is visible on white background
        )

        TableScreen(
            tableData = tableData,
            onAddRow = { tableData.add(WorkoutEntry("", 0, 0, "")) }
        )
    }
}

@Composable
fun TableCell(
    text: String,
    weight: Float,
    onTextChanged: (String) -> Unit
) {
    var state by remember { mutableStateOf(text) }

    BasicTextField(
        value = state,
        onValueChange = {
            state = it
            onTextChanged(it)
        },
        modifier = Modifier
            .border(1.dp, Color.Black)
            .padding(8.dp)
    )
}

@Composable
fun TableScreen(
    tableData: MutableList<WorkoutEntry>,
    onAddRow: () -> Unit
) {
    // Weights for com.example.mylifestyle.screens.Exercise, Sets, Reps, and Time columns
    val columnWeights = listOf(.6f, .1f, .1f, .2f)

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Row(Modifier.background(Color.Gray)) {
                Text("com.example.mylifestyle.screens.Exercise", Modifier.weight(columnWeights[0]))
                Text("Sets", Modifier.weight(columnWeights[1]))
                Text("Reps", Modifier.weight(columnWeights[2]))
                Text("Time", Modifier.weight(columnWeights[3]))
            }
        }

        items(tableData) { entry ->
            Row(Modifier.fillMaxWidth()) {
                TableCell(text = entry.exercise, weight = columnWeights[0]) { newText ->
                    entry.exercise = newText // Update the text directly
                }
                TableCell(text = entry.sets.toString(), weight = columnWeights[1]) { newText ->
                    entry.sets = newText.toIntOrNull() ?: entry.sets // Update with validation
                }
                TableCell(text = entry.reps.toString(), weight = columnWeights[2]) { newText ->
                    entry.reps = newText.toIntOrNull() ?: entry.reps
                }
                TableCell(text = entry.time ?: "", weight = columnWeights[3]) { newText ->
                    entry.time = newText
                }
            }
        }
        item {
            Button(
                onClick = onAddRow,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Add Row")
            }
        }
    }
}

@Preview
@Composable
fun WorkoutScreenPreview() {
    WorkoutTemplate()
}
*/