package com.udacity.shoestore.features.addmore

import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.models.Shoe

class AddShoeFragment : BaseFragment<FragmentAddShoeBinding>() {

    private val shoe = Shoe("AD Lite", 7.5, "ABC company", "It is good")

    override fun getViewBinding() = R.layout.fragment_add_shoe


    override fun initData() {
        mFragmentBinding.shareViewModelAddShoe = shareViewModel
        mFragmentBinding.lifecycleOwner = this
        mFragmentBinding.shoe = shoe
    }

    override fun initViews() {
        (this.activity as MainActivity).findViewById<Toolbar>(R.id.toolbar)
            .title = this.javaClass.simpleName
    }

    override fun initActions() {
        mFragmentBinding.btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initObserver() {
        shareViewModel.isAddedShoe.observe(viewLifecycleOwner) {
            if (it) {
                shareViewModel.onEventAddShoeComplete()
                findNavController().popBackStack()
            }
        }
    }
}