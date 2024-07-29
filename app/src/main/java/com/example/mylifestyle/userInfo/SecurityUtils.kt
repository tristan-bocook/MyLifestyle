package com.example.mylifestyle.userInfo

import org.mindrot.jbcrypt.BCrypt

object SecurityUtils {
    fun hashPassword(password: String): String {
        try {
            return BCrypt.hashpw(password, BCrypt.gensalt(12))  // Adjusted work factor for better security
        } catch (e: Exception) {
            throw RuntimeException("Error hashing password", e)
        }
    }

    fun checkPassword(plainPassword: String, hashedPassword: String): Boolean {
        try {
            return BCrypt.checkpw(plainPassword, hashedPassword)
        } catch (e: Exception) {
            throw RuntimeException("Error checking password", e)
        }
    }
}
