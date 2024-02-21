package com.udacity.shoestore.shareviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShareViewModel : ViewModel() {

    private val _isPressAddShoe = MutableLiveData(false)
    val isPressAddShoe: LiveData<Boolean> get() = _isPressAddShoe

    //Cancel
    private val _eventCancelShoe = MutableLiveData(false)
    val eventCancelShoe: LiveData<Boolean> get() = _eventCancelShoe

    //Add
    private val _eventAddShoe = MutableLiveData(false)
    val eventAddShoe: LiveData<Boolean> get() = _eventAddShoe

    var shoe = Shoe("Shoe", 7.0, "ABC", "Good shoe", mutableListOf())

    private var _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: LiveData<MutableList<Shoe>> get() = _shoesList

    init {
        _shoesList.value = mutableListOf(shoe, shoe, shoe, shoe)
    }

    fun openAddShoeScreen() {
        _isPressAddShoe.value = true
    }

    fun openAddShoeScreenComplete() {
        _isPressAddShoe.value = false
    }

    //Cancel
    fun cancelAddShoe() {
        _eventCancelShoe.value = true
    }

    fun cancelAddShoeComplete() {
        _eventCancelShoe.value = false
    }

    fun addMoreShoe() {
        val list: MutableList<Shoe>? = _shoesList.value
        list?.let {
            it.add(shoe)
            _shoesList.setValue(it)
        }
        _eventAddShoe.value = true
        /*when {
            shoe.description.trim().isEmpty() -> {
                //_eventDescriptionFailed.value = true
            }

            shoe.name.trim().isEmpty() -> {
                //_eventNameFailed.value = true
            }

            else -> {
                val list: MutableList<Shoe>? = _shoesList.value
                list?.let {
                    it.add(shoe)
                    _shoesList.setValue(it)
                }
                _eventAddShoe.value = true
            }
        }*/
    }

    fun addMoreShoeComplete() {
        _eventAddShoe.value = false
    }



}