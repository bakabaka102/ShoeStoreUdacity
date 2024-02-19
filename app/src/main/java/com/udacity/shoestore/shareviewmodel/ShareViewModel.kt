package com.udacity.shoestore.shareviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

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

    //For Shoes List
    var shoe = Shoe("Shoe 1", 7.0, "ABC", "Good shoe", mutableListOf())

    private val _toShoeListScreen = MutableLiveData(false)
    val toShoeListScreen: LiveData<Boolean> get() = _toShoeListScreen

    fun goToShoeListScreen() {
        _toShoeListScreen.value = true
    }

    fun goToShoeListScreenComplete() {
        _toShoeListScreen.value = false
    }


    private var _shoesList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoesList: LiveData<MutableList<Shoe>> get() = _shoesList

    init {
        _shoesList.value = mutableListOf(shoe, shoe, shoe, shoe)
    }

    private fun addNewShoe() {
        val list: MutableList<Shoe>? = _shoesList.value
        list?.let {
            it.add(shoe)
            _shoesList.setValue(it)
        }
    }

}