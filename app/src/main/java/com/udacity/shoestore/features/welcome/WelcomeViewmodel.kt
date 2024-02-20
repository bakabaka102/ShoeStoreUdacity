package com.udacity.shoestore.features.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewmodel: ViewModel() {

    private val _toInstructionScreen = MutableLiveData(false)
    val toInstructionScreen: LiveData<Boolean> get() = _toInstructionScreen

    fun goToInstructionScreen() {
        _toInstructionScreen.value = true
    }

    fun goToInstructionScreenComplete() {
        _toInstructionScreen.value = false
    }
}