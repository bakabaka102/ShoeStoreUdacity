package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
    }
}
