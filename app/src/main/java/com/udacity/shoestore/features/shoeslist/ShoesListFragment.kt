package com.udacity.shoestore.features.shoeslist

import android.content.Intent
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.databinding.LayoutItemShoeBinding
import com.udacity.shoestore.models.Shoe

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
    }

    override fun initObserver() {
        shareViewModel.shoesList.observe(viewLifecycleOwner) {
            Log.d("List", it.toString())
            bindShoeList(it)
        }
        observerNavigateAddShoeScreen()
    }

    private fun bindShoeList(shoesList: MutableList<Shoe>) {
        val itemParent = mFragmentBinding.lnShoeItem
        for (shoe in shoesList) {
            val itemBinding: LayoutItemShoeBinding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.layout_item_shoe,
                itemParent,
                false
            )
            itemBinding.nameShoe.text = shoe.name
            itemBinding.descriptionShoe.text = shoe.company
            itemBinding.sizeShoe.text = shoe.size.toString()
            itemParent.addView(itemBinding.root)
        }
    }

    private fun observerNavigateAddShoeScreen() {
        shareViewModel.isPressAddShoe.observe(viewLifecycleOwner) {
            if (it) {
                navigateAddShoeScreen()
                shareViewModel.openAddShoeScreenComplete()
            }
        }
    }

    private fun navigateAddShoeScreen() {
        findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToAddShoeFragment())
    }

}