package com.udacity.shoestore.features.welcome

import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {

    override fun initData() {
        mFragmentBinding.shareViewModelWelcome = shareViewModel
    }

    override fun initViews() {

    }

    override fun initActions() {

    }

    override fun initObserver() {
        observerNavigationInstruction()
    }

    override fun getViewBinding(): Int = R.layout.fragment_welcome

    private fun navigateToInstruction() {
        findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToRegisterFragment())
    }

    private fun observerNavigationInstruction() {
        shareViewModel.welcomeSuccess.observe(viewLifecycleOwner) {
            if (it) {
                navigateToInstruction()
                shareViewModel.toComeInstructionScreen()
            }
        }
    }
}