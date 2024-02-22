package com.udacity.shoestore.features.shoeslist

import android.content.Intent
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.databinding.LayoutItemShoeBinding

class ShoesListFragment : BaseFragment<FragmentShoesListBinding>() {

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val i = Intent()
            i.action = Intent.ACTION_MAIN
            i.addCategory(Intent.CATEGORY_HOME)
            startActivity(i)
        }
    }

    override fun getViewBinding() = R.layout.fragment_shoes_list


    override fun initData() {
        mFragmentBinding.shareViewModelShoesList = shareViewModel
    }

    override fun initViews() {
        (this.activity as MainActivity).findViewById<Toolbar>(R.id.toolbar).title =
            this.javaClass.simpleName
    }

    override fun initActions() {
        activity?.onBackPressedDispatcher?.addCallback(this, onBackPressedCallback)
        mFragmentBinding.fabAddShoe.setOnClickListener {
            navigateAddShoeScreen()
        }
    }

    override fun initObserver() {
        shareViewModel.shoesList.observe(viewLifecycleOwner) {
            val itemParent = mFragmentBinding.lnShoeItem
            for (shoe in it) {
                val itemBinding: LayoutItemShoeBinding = DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.layout_item_shoe,
                    itemParent,
                    false
                )
                itemBinding.shoeItemData = shoe
                itemParent.addView(itemBinding.root)
            }
        }
    }

    private fun navigateAddShoeScreen() {
        findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToAddShoeFragment())
    }

}