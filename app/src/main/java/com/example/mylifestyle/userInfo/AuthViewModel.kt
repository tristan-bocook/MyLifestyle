package com.example.mylifestyle.userInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthViewModel(private val userDao: UserDao) : ViewModel() {
    private val _isLoggedIn = MutableLiveData(false)
    val isLoggedIn: LiveData<Boolean> = _isLoggedIn

    private val _loginError = MutableLiveData<String?>()
    val loginError: LiveData<String?> = _loginError

    fun registerUser(username: String, email: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val hashedPassword = SecurityUtils.hashPassword(password)
                val newUser = User(username = username, email = email, password = hashedPassword)
                val result = userDao.insertUser(newUser)
                if (result > 0) {
                    _loginError.postValue(null)
                    onResult(true)
                } else {
                    _loginError.postValue("Registration failed: User not added.")
                    onResult(false)
                }
            } catch (e: Exception) {
                _loginError.postValue("Registration failed: ${e.localizedMessage}")
                onResult(false)
            }
        }
    }

    fun login(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val user = userDao.getUserByUsername(username)
                if (user != null && SecurityUtils.checkPassword(password, user.password)) {
                    _isLoggedIn.postValue(true)
                    _loginError.postValue(null)
                } else {
                    _isLoggedIn.postValue(false)
                    _loginError.postValue("Invalid credentials")
                }
            } catch (e: Exception) {
                _loginError.postValue("Login failed: ${e.localizedMessage}")
                _isLoggedIn.postValue(false)
            }
        }
    }

    fun logout() {
        _isLoggedIn.postValue(false)
    }
}


