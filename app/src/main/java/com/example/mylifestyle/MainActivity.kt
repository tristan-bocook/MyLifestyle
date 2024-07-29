package com.example.mylifestyle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.ViewModelProvider
import com.example.mylifestyle.ui.theme.MyLifestyleTheme
import com.example.mylifestyle.userInfo.AppDatabase
import com.example.mylifestyle.userInfo.AuthViewModel
import com.example.mylifestyle.userInfo.AuthViewModelFactory


class MainActivity : ComponentActivity() {
    //@OptIn(ExperimentalMaterial3Api::class)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userDao = AppDatabase.getDatabase(this.application).userDao()
        val factory = AuthViewModelFactory(userDao)
        val authViewModel = ViewModelProvider(this, factory)[AuthViewModel::class.java]

        setContent {
            MyLifestyleTheme{
                // Pass authViewModel to MainScreen
                MainScreen()
            }
        }
    }
}
