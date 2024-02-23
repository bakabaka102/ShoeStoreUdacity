package com.udacity.shoestore.features.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    private val _eventRegisterSuccess = MutableLiveData(false)
    val registerSuccess: LiveData<Boolean> get() = _eventRegisterSuccess

    fun startWelcomeScreen() {
        _eventRegisterSuccess.value = true
    }

    fun toComeWelcomeScreen() {
        _eventRegisterSuccess.value = false
    }
}