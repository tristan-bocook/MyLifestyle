package com.example.mylifestyle

/*package com.example.mylifestyle

import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.mylifestyle.userInfo.AuthViewModel
import com.example.mylifestyle.userInfo.LoginScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(authViewModel: AuthViewModel = viewModel()) {
    val navController = rememberNavController()
    val isLoggedIn by authViewModel.isLoggedIn.observeAsState(false)

    Scaffold(
        bottomBar = {
            if (isLoggedIn) {
                BottomBar(navController, authViewModel)
            }
        }
    ) {
        if (isLoggedIn) {
            BottomNavGraph(navController = navController)  // The main content of the app
        } else {
            LoginScreen(navController, authViewModel::login)  // Display the Login Screen
        }
    }
}*/

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

/*
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(authViewModel: AuthViewModel = viewModel()) {
    val navController = rememberNavController()
    val isLoggedIn by authViewModel.isLoggedIn.observeAsState(false)

    Scaffold(
        bottomBar = {
            if (isLoggedIn) {
                BottomBar(navController, authViewModel)
            }
        }
    ) {
        if (isLoggedIn) {
            BottomNavGraph(navController = navController, authViewModel = authViewModel)
        } else {
            LoginScreen(navController, authViewModel)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController, authViewModel: AuthViewModel) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Exercises,
        BottomBarScreen.WorkoutTemplate
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Surface(color = MaterialTheme.colorScheme.background) {
        NavigationBar(contentColor = MaterialTheme.colorScheme.onSurface) {
            screens.forEach { screen ->
                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                    onClick = {
                        if (navController.currentDestination?.route != screen.route) {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    icon = { Icon(imageVector = screen.icon, contentDescription = "Navigation Icon") },
                    label = { Text(text = screen.title) }
                )
            }
        }
    }
}
*/


//old code below

/*
package com.example.mylifestyle

import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mylifestyle.userInfo.AuthViewModel
import com.example.mylifestyle.userInfo.LoginScreen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(authViewModel: AuthViewModel = viewModel()) {
    val navController = rememberNavController()
    val isLoggedIn by authViewModel.isLoggedIn.observeAsState(false)

    Scaffold(
        bottomBar = {
            if (isLoggedIn) BottomBar(navController, authViewModel)
        }
    ) {
        if (isLoggedIn) {
            BottomNavGraph(navController = navController)
        } else {
            LoginScreen(navController, authViewModel::login)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController, authViewModel: AuthViewModel) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Exercises,
        BottomBarScreen.WorkoutTemplate
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Surface(color = MaterialTheme.colorScheme.background) {
        NavigationBar(contentColor = MaterialTheme.colorScheme.onSurface) {
            screens.forEach { screen ->
                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                    onClick = {
                        if (navController.currentDestination?.route != screen.route) {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    icon = { Icon(imageVector = screen.icon, contentDescription = "Navigation Icon") },
                    label = { Text(text = screen.title) }
                )
            }
        }
    }
}


*/


/*package com.example.mylifestyle

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue



import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mylifestyle.userInfo.AuthViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(authViewModel: AuthViewModel = viewModel()) {
    val navController = rememberNavController()
    val isLoggedIn by authViewModel.isLoggedIn.observeAsState(false)

    Scaffold(
        bottomBar = { if (isLoggedIn) BottomBar(navController, authViewModel) }
    ) {
        if (isLoggedIn) {
            BottomNavGraph(navController = navController)
        } else {
            LoginScreen(authViewModel = authViewModel)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController, authViewModel: AuthViewModel) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.com.example.mylifestyle.screens.Exercises,
        BottomBarScreen.WorkoutTemplate
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Surface(color = MaterialTheme.colorScheme.background) {
        NavigationBar(contentColor = MaterialTheme.colorScheme.onSurface) {
            screens.forEach { screen ->
                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                    onClick = {
                        if (navController.currentDestination?.route != screen.route) {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    icon = { Icon(imageVector = screen.icon, contentDescription = "Navigation Icon") },
                    label = { Text(text = screen.title) }
                )
            }
        }
    }
}

@Composable
fun LoginScreen(authViewModel: AuthViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginError by authViewModel.loginError.observeAsState()

    Column(
        modifier = Modifier.padding(16.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (loginError != null) {
            Text(text = "Login failed: $loginError", color = MaterialTheme.colorScheme.error)
        }

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (username.isNotEmpty() && password.isNotEmpty()) {
                authViewModel.login(username, password)
            }
        }) {
            Text("Login")
        }
    }
}*/






@ExperimentalMaterial3Api
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController)}
    ) {
    @Suppress("UNUSED_EXPRESSION")
    it
        BottomNavGraph(navController = navController)

    }

}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Exercises,
        BottomBarScreen.WorkoutTemplate,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }


}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
   NavigationBarItem(currentDestination?.hierarchy?.any {
       it.route == screen.route
   } == true, {
       navController.navigate(screen.route) {
           popUpTo(navController.graph.findStartDestination().id)
           launchSingleTop = true
       }
   }, {
       Icon(
           imageVector = screen.icon,
           contentDescription = "Navigation Icon"
       )
   }, label = {
       Text(text = screen.title)
   }
   )
}


