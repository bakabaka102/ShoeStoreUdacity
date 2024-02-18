package com.udacity.shoestore.shareviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel : ViewModel() {

    //For login action
    private val _eventLoginSuccess = MutableLiveData(false)
    val loginSuccess: LiveData<Boolean> get() = _eventLoginSuccess

    private val _eventNextWelcomeSuccess = MutableLiveData(false)
    val welcomeSuccess get() = _eventNextWelcomeSuccess


    //For login action
    fun startNextLoginScreen() {
        _eventLoginSuccess.value = true
    }

    fun toComeWelcomeScreen() {
        _eventLoginSuccess.value = false
    }

    //For Next welcome screen
    fun startNextWelcomeScreen() {
        _eventNextWelcomeSuccess.value = true
    }

    fun toComeInstructionScreen() {
        _eventNextWelcomeSuccess.value = false
    }

}