package com.example.mylifestyle.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mylifestyle.R


@Composable
fun ExerciseDetail(navController: NavController, exercises: List<Exercise>, exerciseId: Int) {
    val exercise = exercises.find { it.id == exerciseId } ?: return  // Ensure this handling is appropriate

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Image(
            painter = painterResource(id = exercise.imageRes),
            contentDescription = exercise.name,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
        )
        Text(text = exercise.name, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Text(text = exercise.muscleGroups, fontSize = 18.sp)
        Text(text = "Description", fontSize = 20.sp, fontWeight = FontWeight.Medium)
        Text(text = exercise.description, fontSize = 16.sp)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewExerciseDetail() {
    val sampleExercise = Exercise(
        id = 0,
        imageRes = R.drawable.bench,
        name = "Bench Press",
        muscleGroups = "Pectorals, Anterior Deltoid, Triceps, Biceps",
        description = "The bench press is a key exercise to develop upper body strength and mass."
    )
    val navController = rememberNavController()
    ExerciseDetail(navController = navController, exercises = listOf(sampleExercise), exerciseId = 0)
}
