package com.example.mylifestyle.screens
/*
package com.example.mylifestyle.screens

import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mylifestyle.R
import androidx.compose.ui.Modifier



@Composable
fun com.example.mylifestyle.screens.Exercises(
    imageId: Array<Int>,
    exercise: Array<String>,
    muscleGroups: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
   LazyColumn(contentPadding = PaddingValues(16.dp)) {
       val itemCount = imageId.size
       items(itemCount){
           ColumnItem(

               painter = imageId,
               exercise = exercise,
               muscleGroups = muscleGroups,
               itemIndex = it,
               navController = navController,
               modifier = Modifier
           )

       }
   }
}

@Composable
fun ColumnItem(
    modifier: Modifier,
    painter: Array<Int>,
    exercise: Array<String>,
    muscleGroups: Array<String>,
    itemIndex: Int,
    navController: NavController
) {
    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route= "ExerciseDetail/$itemIndex")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)

    ) {
        Row(modifier.fillMaxWidth(),
            verticalAlignment = Layout.Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            Image(painter = painterResource(id = painter[itemIndex]),
                contentDescription = exercise[itemIndex],
                modifier.size(140.dp)
            )
            Column(modifier.padding(12.dp)) {
                Text(text = exercise[itemIndex],
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp)
                Text(text = muscleGroups[itemIndex],
                    fontSize = 18.sp)
            }
        }

    }
}

@Composable
@Preview
fun ExercisesPreview() {

    val imageId = arrayOf(
        R.drawable.bench,
        R.drawable.squat,
        R.drawable.deadlifts
    )

    val exercise = arrayOf("Bench Press", "Squat", "Deadlift")

    val muscleGroups = arrayOf(
        "Pectorals, Anterior Deltoid, Triceps, Biceps",
        "Quadriceps, Hamstrings, Glutes, Abdominals, Calves",
        "Glutes, Hamstrings, Abdominals, Back, Trapezius"
    )

    val description = arrayOf(
        "The bench press is a compound exercise that targets the muscles of the upper body It " +
                "involves lying on a bench and pressing weight upward using either a barbell or a " +
                "pair of dumbbells. During a bench press, you lower the weight down to chest level " +
                "and then press upwards while extending your arms. This movement is considered one " +
                "repetition, or rep There are several variations of bench presses that each work " +
                "different muscles. These may involve lying flat, lying at an incline or decline, " +
                "or placing your hands closer together on the barbell.",
        "Place a barbell in a rack just below shoulder-height. Dip under the bar to put it behind " +
                "the neck across the top of the back, and grip the bar with the hands wider than " +
                "shoulder-width apart. Lift the chest up and squeeze the shoulder blades together to " +
                "keep the straight back throughout the entire movement. Stand up to bring the bar " +
                "off the rack and step backwards, then place the feet so that they are a little " +
                "wider than shoulder-width apart. Sit back into hips and keep the back straight and " +
                "the chest up, squatting down so the hips are below the knees. From the bottom of " +
                "the squat, press feet into the ground and push hips forward to return to the top of " +
                "the standing position.",
        "Step up to the loaded barbell, starting with your feet about shoulder-width apart (this " +
                "might vary by your anatomy and personal preference with experience), with your feet " +
                "under the bar. Your shins should be close to or actually touching the bar Push your " +
                "butt back and hinge at the waist to bend down to grab the bar on either side of " +
                "your legs. Grasp it in both hands using an overhand grip Make sure your hips are " +
                "lower than your shoulders. Squeeze your shoulder blades together to set your lats, " +
                "then engage your core. Keep your neck in a neutral position; don't look up Push " +
                "your feet through the floor and pull the weight up, keeping the bar close to your " +
                "body. You might find that you scrape your shins with the bar, that's okay. Invest " +
                "in long socks or wear pants. Squeeze your glutes at the top of the list, but don't " +
                "lean back."
    )

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "com.example.mylifestyle.screens.Exercises") {
        composable(route = "com.example.mylifestyle.screens.Exercises") {
            com.example.mylifestyle.screens.Exercises(
                imageId = imageId,
                exercise = exercise,
                muscleGroups = muscleGroups,
                modifier = Modifier.fillMaxSize(),
                navController = navController
            )
        }
        composable(route = "ExerciseDetail/{index}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                }
            )
        ) { index->
            ExerciseDetail(
                photos = imageId,
                exercise = exercise,
                muscleGroups = muscleGroups,
                itemIndex = index.arguments?.getInt("index"),
                description = description
            )
        }
    }
}*/
/*
package com.example.mylifestyle.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mylifestyle.R

@Composable
fun com.example.mylifestyle.screens.Exercises(
    imageId: Array<Int>,
    exercise: Array<String>,
    muscleGroups: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(imageId.size) { index ->
            ColumnItem(
                painterId = imageId[index],
                exerciseName = exercise[index],
                muscleGroup = muscleGroups[index],
                navController = navController,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun ColumnItem(
    modifier: Modifier = Modifier,
    painterId: Int,
    exerciseName: String,
    muscleGroup: String,
    navController: NavController
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate("ExerciseDetail/$painterId")
            },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painterId),
                contentDescription = exerciseName,
                modifier = Modifier.size(140.dp)
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(text = exerciseName, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = muscleGroup, fontSize = 18.sp)
            }
        }
    }
}

@Composable
@Preview
fun ExercisesPreview() {
    val imageId = arrayOf(
        R.drawable.bench,
        R.drawable.squat,
        R.drawable.deadlifts
    )
    val exercise = arrayOf("Bench Press", "Squat", "Deadlift")
    val muscleGroups = arrayOf(
        "Pectorals, Anterior Deltoid, Triceps, Biceps",
        "Quadriceps, Hamstrings, Glutes, Abdominals, Calves",
        "Glutes, Hamstrings, Abdominals, Back, Trapezius"
    )

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "com.example.mylifestyle.screens.Exercises") {
        composable(route = "com.example.mylifestyle.screens.Exercises") {
            com.example.mylifestyle.screens.Exercises(
                imageId = imageId,
                exercise = exercise,
                muscleGroups = muscleGroups,
                navController = navController,
                modifier = Modifier.fillMaxSize()
            )
        }
        composable(
            route = "ExerciseDetail/{index}",
            arguments = listOf(navArgument("index") { type = NavType.IntType })
        ) { backStackEntry ->
            // Detail screen not shown here, implement accordingly
        }
    }
}
*/
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mylifestyle.R


data class Exercise(
    val id: Int,
    val imageRes: Int,
    val name: String,
    val muscleGroups: String,
    val description: String
)

val exercises = listOf(
    Exercise(
        id = 0,
        imageRes = R.drawable.bench,
        name = "Bench Press",
        muscleGroups = "Pectorals, Anterior Deltoid, Triceps, Biceps",
        description = "The bench press is a key exercise to develop upper body strength and mass, predominantly targeting the pectoral muscles, triceps, and anterior deltoids."
    ),
    Exercise(
        id = 1,
        imageRes = R.drawable.squat,
        name = "Squat",
        muscleGroups = "Quadriceps, Hamstrings, Glutes, Abdominals, Calves",
        description = "Squats are a powerful compound exercise that targets the lower body, engaging the quads, hamstrings, and glutes prominently."
    ),
    Exercise(
        id = 2,
        imageRes = R.drawable.deadlifts,
        name = "Deadlift",
        muscleGroups = "Glutes, Hamstrings, Lower Back, Trapezius",
        description = "The deadlift is an essential exercise for building strength in the lower back, glutes, and hamstrings."
    )
)


@Composable
fun Exercises(navController: NavController, exercises: List<Exercise>) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(exercises) { exercise ->
            ExerciseCard(exercise, navController)
        }
    }
}

@Composable
fun ExerciseCard(exercise: Exercise, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { navController.navigate("ExerciseDetail/${exercise.id}") },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 12.dp
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = exercise.imageRes),
                contentDescription = exercise.name,
                modifier = Modifier.size(100.dp)
            )
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = exercise.name, style = MaterialTheme.typography.headlineSmall)
                Text(text = exercise.muscleGroups, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewExercises() {
    val sampleExercises = listOf(
        Exercise(
            id = 0,
            imageRes = R.drawable.bench,
            name = "Bench Press",
            muscleGroups = "Pectorals, Anterior Deltoid, Triceps, Biceps",
            description = "The bench press is a key exercise to develop upper body strength and mass."
        ),
        Exercise(
            id = 1,
            imageRes = R.drawable.squat,
            name = "Squat",
            muscleGroups = "Quadriceps, Hamstrings, Glutes, Abdominals, Calves",
            description = "Squats are a powerful compound exercise that targets the lower body."
        )
    )
    val navController = rememberNavController()
    Exercises(navController = navController, exercises = sampleExercises)
}
