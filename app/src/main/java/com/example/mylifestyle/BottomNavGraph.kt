/*
package com.example.mylifestyle

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mylifestyle.screens.ExerciseDetail
import com.example.mylifestyle.screens.Exercises
import com.example.mylifestyle.screens.HomeScreen
import com.example.mylifestyle.screens.WorkoutTemplate
import com.example.mylifestyle.screens.exercises


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.WorkoutTemplate.route) {
            WorkoutTemplate()
        }
        composable(route = BottomBarScreen.Exercises.route) {
            // Assuming you now have a ViewModel or a similar setup to provide exercises
            Exercises(navController = navController, exercises = exercises)
        }
        composable(route = "ExerciseDetail/{exerciseId}",
            arguments = listOf(navArgument("exerciseId") { type = NavType.IntType })) { backStackEntry ->
            val exerciseId = backStackEntry.arguments?.getInt("exerciseId") ?: return@composable
            ExerciseDetail(navController = navController, exercises = exercises, exerciseId = exerciseId)
        }
    }
}
*/
package com.example.mylifestyle

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mylifestyle.screens.ExerciseDetail
import com.example.mylifestyle.screens.Exercises
import com.example.mylifestyle.screens.HomeScreen
import com.example.mylifestyle.screens.WorkoutTemplate
import com.example.mylifestyle.screens.exercises

@Composable
//fun BottomNavGraph(navController: NavHostController, authViewModel: AuthViewModel) {
fun BottomNavGraph(navController: NavHostController) {
    // Observe the logged-in state
    /*    val isLoggedIn = authViewModel.isLoggedIn.value ?: false

    LaunchedEffect(isLoggedIn) {
        if (!isLoggedIn) {
            // Redirect to login screen if not logged in
            navController.navigate("login") {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                }
            }
        }
    }*/

    //NavHost(navController = navController, startDestination = if (isLoggedIn) BottomBarScreen.Home.route else "login") {
    NavHost(navController = navController, startDestination = "home") {

        // composable("login") {
        // Define the LoginScreen. Assuming you pass a login function from the AuthViewModel
        //LoginScreen(navController, authViewModel)
        //  }
        composable(BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(BottomBarScreen.WorkoutTemplate.route) {
            WorkoutTemplate()
        }
        composable(BottomBarScreen.Exercises.route) {
            Exercises(navController = navController, exercises = exercises)
        }
        composable(route = "ExerciseDetail/{exerciseId}",
            arguments = listOf(navArgument("exerciseId") { type = NavType.IntType })
        ) { backStackEntry ->
            val exerciseId = backStackEntry.arguments?.getInt("exerciseId") ?: return@composable
            ExerciseDetail(
                navController = navController,
                exercises = exercises,
                exerciseId = exerciseId
            )
            //}
        }
    }
}