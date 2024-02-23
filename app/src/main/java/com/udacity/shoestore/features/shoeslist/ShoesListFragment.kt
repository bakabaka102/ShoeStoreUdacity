package com.udacity.shoestore.features.shoeslist

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.databinding.LayoutItemShoeBinding

class ShoesListFragment : BaseFragment<FragmentShoesListBinding>(), MenuProvider {

    private val mOnBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            activity?.finish()
        }
    }

    override fun getViewBinding() = R.layout.fragment_shoes_list


    override fun initData() {
        mFragmentBinding.shareViewModelShoesList = shareViewModel
    }

    override fun initViews() {
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (this.activity as MainActivity).findViewById<Toolbar>(R.id.toolbar)
            .title = this.javaClass.simpleName
    }

    override fun initActions() {
        activity?.onBackPressedDispatcher?.addCallback(this, mOnBackPressedCallback)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.menuItemLogout -> {
                findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToLoginFragment())
                true
            }

            else -> false
        }
    }

}