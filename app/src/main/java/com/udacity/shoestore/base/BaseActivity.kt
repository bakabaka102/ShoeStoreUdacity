package com.udacity.shoestore.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import timber.log.Timber

abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var mBinding: VB

    abstract fun instanceViewBinding(): VB

    abstract fun initData()

    abstract fun initViews()

    abstract fun initActions()

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = instanceViewBinding()
        setContentView(mBinding.root)
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        mBinding = instanceViewBinding()
        setContentView(mBinding.root)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        initData()
        initViews()
        initActions()
        Timber.plant(Timber.DebugTree())
    }
}