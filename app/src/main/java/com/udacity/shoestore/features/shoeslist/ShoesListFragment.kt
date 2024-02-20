package com.udacity.shoestore.features.shoeslist

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

    override fun getViewBinding() = R.layout.fragment_shoes_list


    override fun initData() {
        mFragmentBinding.shareViewModelShoesList = shareViewModel
    }

    override fun initViews() {
        (this.activity as MainActivity).findViewById<Toolbar>(R.id.toolbar).title =
            this.javaClass.simpleName
    }

    override fun initActions() {

    }

    override fun initObserver() {
        shareViewModel.shoesList.observe(viewLifecycleOwner) {
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