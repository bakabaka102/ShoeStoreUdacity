package com.udacity.shoestore.features.register

import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentRegisterBinding

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    override fun getViewBinding() = R.layout.fragment_register

    override fun initData() {
        mFragmentBinding.shareViewModelRegister = shareViewModel
    }

    override fun initViews() {

    }

    override fun initActions() {

    }

    override fun initObserver() {
        observerNavigationShoeList()
    }
    
    private fun observerNavigationShoeList() {
        shareViewModel.toShoeListScreen.observe(viewLifecycleOwner) {
            if (it) {
                navigateToToWelcome()
                shareViewModel.toComeWelcomeScreen()
            }
        }
    }

    private fun navigateToToWelcome() {
        findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToShoesListFragment())
    }

}