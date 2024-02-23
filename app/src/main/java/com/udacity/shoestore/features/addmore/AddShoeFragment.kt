package com.udacity.shoestore.features.addmore

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.models.Shoe

class AddShoeFragment : BaseFragment<FragmentAddShoeBinding>() {

    private val shoe = Shoe("AD Lite", 0.0, "ABC company", "It is good")

    override fun getViewBinding() = R.layout.fragment_add_shoe


    override fun initData() {
        mFragmentBinding.shareViewModelAddShoe = shareViewModel
        mFragmentBinding.lifecycleOwner = this
        mFragmentBinding.shoe = shoe
    }

    override fun initViews() {
        (this.activity as MainActivity).findViewById<Toolbar>(R.id.toolbar)
            .title = this.javaClass.simpleName
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
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