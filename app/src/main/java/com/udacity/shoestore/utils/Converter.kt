package com.udacity.shoestore.utils

import androidx.databinding.InverseMethod

object Converter {
    
    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(value: Double): String {
        return value.toString()
    }

    @JvmStatic
    fun stringToDouble(value: String): Double {
        return try {
            value.toDouble()
        } catch (ex: Exception) {
            0.0
        }
    }
}
