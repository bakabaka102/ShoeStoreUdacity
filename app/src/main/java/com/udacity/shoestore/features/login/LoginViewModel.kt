package com.udacity.shoestore.features.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _eventLoginSuccess = MutableLiveData(false)
    val loginSuccess: LiveData<Boolean> get() = _eventLoginSuccess

    fun startNextLoginScreen() {
        _eventLoginSuccess.value = true
    }

    fun toComeWelcomeScreen() {
        _eventLoginSuccess.value = false
    }
}