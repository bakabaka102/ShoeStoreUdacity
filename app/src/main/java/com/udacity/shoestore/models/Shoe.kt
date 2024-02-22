package com.udacity.shoestore.models

import android.os.Parcelable
import android.util.Log
import android.widget.EditText
import androidx.databinding.InverseBindingAdapter
import kotlinx.parcelize.Parcelize
import timber.log.Timber

@Parcelize
data class Shoe(
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
    val images: List<String> = mutableListOf(),
) : Parcelable

@InverseBindingAdapter(attribute = "android:text")
fun EditText.getShoeSize() : String {
    Timber.tag("getShoeSize").i("getShoeSize")
    return this.text.toString()
}
