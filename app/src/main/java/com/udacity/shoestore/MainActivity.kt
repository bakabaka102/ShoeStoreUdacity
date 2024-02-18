package com.udacity.shoestore

import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.udacity.shoestore.base.BaseActivity
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var navController: NavController

    override fun getNavController(): NavController {
        navController = this.findNavController(R.id.mainContainerView)
        return navController
        //val mainContainerView = mBinding.mainContainerView as NavHostFragment
        /*val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainContainerView) as NavHostFragment
        return navHostFragment.navController*/
    }

    override fun instanceViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun initData() {

    }

    override fun initViews() {

    }

    override fun initActions() {

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
    }*/
}
