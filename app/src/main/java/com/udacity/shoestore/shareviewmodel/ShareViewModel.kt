package com.udacity.shoestore.shareviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShareViewModel : ViewModel() {

    private val _isPressAddShoe = MutableLiveData(false)
    val isPressAddShoe: LiveData<Boolean> get() = _isPressAddShoe
    fun openAddShoeScreen() {
        _isPressAddShoe.value = true
    }

    fun openAddShoeScreenComplete() {
        _isPressAddShoe.value = false
    }

    var shoe = Shoe("Shoe 1", 7.0, "ABC", "Good shoe", mutableListOf())

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