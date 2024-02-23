package com.udacity.shoestore.shareviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShareViewModel : ViewModel() {

    private var _isAddedShoe = MutableLiveData<Boolean>()
    val isAddedShoe: LiveData<Boolean> get() = _isAddedShoe

    private var _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: LiveData<MutableList<Shoe>> get() = _shoesList

    init {
        _shoesList.value = mutableListOf()
        _shoesList.value = mutableListOf(
            Shoe("Shoe", 7.0, "ABC", "Good shoe", mutableListOf()),
            Shoe("Shoe", 7.0, "ABC", "Good shoe", mutableListOf()),
            Shoe("Shoe", 7.0, "ABC", "Good shoe", mutableListOf())
        )
    }

    fun onEventAddShoe(name: String, size: Double,company: String, description: String) {
        addShoe(name, size, company, description).also { println("habq $size ") }
        _isAddedShoe.value = true
    }

    fun onEventAddShoeComplete() {
        _isAddedShoe.value = false
    }

    private fun addShoe(name: String, size: Double, company: String, description: String) {
        _shoesList.value?.add(Shoe(name, size, company, description))
        Timber.i(_shoesList.value?.joinToString())
    }

}