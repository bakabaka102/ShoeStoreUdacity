package com.udacity.shoestore.features.addmore

import androidx.appcompat.widget.Toolbar
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentAddShoeBinding

class AddShoeFragment : BaseFragment<FragmentAddShoeBinding>() {

    override fun getViewBinding() = R.layout.fragment_add_shoe


    override fun initData() {

    }

    override fun initViews() {
        (this.activity as MainActivity).findViewById<Toolbar>(R.id.toolbar)
            .title = this.javaClass.simpleName
    }

    override fun initActions() {

    }

    override fun initObserver() {

    }


}