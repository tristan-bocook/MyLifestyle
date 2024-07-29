package com.example.mylifestyle.userInfo

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

// User.kt
@Entity(tableName = "users", indices = [Index(value = ["username", "email"], unique = true)])
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String,
    val email: String,
    val password: String  // Consider renaming to hashedPassword for clarity
)