package com.example.mylifestyle

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    data object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        Icons.Default.Home
    )    data object Exercises : BottomBarScreen(
        route = "exercises",
        title = "Exercises",
        Icons.Default.Info
    )    data object WorkoutTemplate : BottomBarScreen(
        route = "workout",
        title = "Workouts",
        Icons.Default.Add
    )
}