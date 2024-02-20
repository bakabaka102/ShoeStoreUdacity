package com.udacity.shoestore.features.instruction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionViewmodel : ViewModel() {

    private val _toShoeListScreen = MutableLiveData(false)
    val toShoeListScreen: LiveData<Boolean> get() = _toShoeListScreen

    fun goToShoeListScreen() {
        _toShoeListScreen.value = true
    }

    fun goToShoeListScreenComplete() {
        _toShoeListScreen.value = false
    }
}