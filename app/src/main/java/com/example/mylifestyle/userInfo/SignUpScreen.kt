/*package com.example.mylifestyle.userInfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SignUpScreen(navController: NavController, authViewModel: AuthViewModel = viewModel()) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }
    var showErrorDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sign Up", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        UserInputField(value = username, label = "Username", onValueChange = { username = it })
        UserInputField(value = email, label = "Email", onValueChange = { email = it })
        PasswordInputField(
            value = password,
            label = "Password",
            visibility = passwordVisibility,
            onVisibilityChange = { passwordVisibility = it },
            onValueChange = { password = it }
        )
        PasswordInputField(
            value = confirmPassword,
            label = "Confirm Password",
            visibility = confirmPasswordVisibility,
            onVisibilityChange = { confirmPasswordVisibility = it },
            onValueChange = { confirmPassword = it }
        )

        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                if (password == confirmPassword) {
                    authViewModel.registerUser(username, email, password) { success ->
                        if (success) {
                            navController.navigate("login") // Ensure this route is correctly defined in your NavGraph
                        } else {
                            showErrorDialog = true
                        }
                    }
                } else {
                    showErrorDialog = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign Up")
        }

        Spacer(Modifier.height(8.dp))
        TextButton(onClick = { navController.navigate("login") }) {
            Text("Already have an account? Log in here.")
        }

        if (showErrorDialog) {
            AlertDialog(
                onDismissRequest = { showErrorDialog = false },
                title = { Text("Error") },
                text = { Text("Passwords do not match. Please try again.") },
                confirmButton = {
                    Button(onClick = { showErrorDialog = false }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}

@Composable
fun UserInputField(value: String, label: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
    )
}

@Composable
fun PasswordInputField(
    value: String,
    label: String,
    visibility: Boolean,
    onVisibilityChange: (Boolean) -> Unit,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { onVisibilityChange(!visibility) }) {
                Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "Toggle password visibility")
            }
        },
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen() {

    val navController = rememberNavController()
    SignUpScreen(navController)
}*/

package com.example.mylifestyle.userInfo

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mylifestyle.ui.theme.MyLifestyleTheme


@Composable
fun SignUpScreen(navController: NavController, context: Context = LocalContext.current, authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory(AppDatabase.getDatabase(context).userDao()))) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }

    // Observe LiveData as state
    val loginError by authViewModel.loginError.observeAsState()

    // Error dialog visibility state
    var showErrorDialog by remember { mutableStateOf(false) }

    LaunchedEffect(loginError) {
        showErrorDialog = !loginError.isNullOrEmpty()
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sign Up", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        UserInputField(value = username, label = "Username", onValueChange = { username = it })
        UserInputField(value = email, label = "Email", onValueChange = { email = it })
        PasswordInputField(
            value = password,
            label = "Password",
            visibility = passwordVisibility,
            onVisibilityChange = { passwordVisibility = it },
            onValueChange = { password = it }
        )
        PasswordInputField(
            value = confirmPassword,
            label = "Confirm Password",
            visibility = confirmPasswordVisibility,
            onVisibilityChange = { confirmPasswordVisibility = it },
            onValueChange = { confirmPassword = it }
        )

        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                if (password == confirmPassword) {
                    authViewModel.registerUser(username, email, password) { success ->
                        if (success) {
                            navController.navigate("login") // Ensure this route is correctly defined in your NavGraph
                        }
                    }
                } else {
                    showErrorDialog = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign Up")
        }

        Spacer(Modifier.height(8.dp))
        TextButton(onClick = { navController.navigate("login") }) {
            Text("Already have an account? Log in here.")
        }

        if (showErrorDialog) {
            AlertDialog(
                onDismissRequest = { showErrorDialog = false },
                title = { Text("Error") },
                text = { Text(loginError ?: "An unexpected error occurred.") },
                confirmButton = {
                    Button(onClick = { showErrorDialog = false }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}

@Composable
fun UserInputField(value: String, label: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun PasswordInputField(value: String, label: String, visibility: Boolean, onVisibilityChange: (Boolean) -> Unit, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { onVisibilityChange(!visibility) }) {
                Icon(
                    imageVector = if (visibility) Icons.Filled.CheckCircle else Icons.Default.CheckCircle,
                    contentDescription = "Toggle password visibility"
                )
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen() {
    MyLifestyleTheme {
        SignUpScreen(rememberNavController())
    }
}

