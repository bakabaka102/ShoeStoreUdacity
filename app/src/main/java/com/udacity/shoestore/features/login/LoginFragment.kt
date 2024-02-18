package com.udacity.shoestore.features.login

import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    override fun getViewBinding() = R.layout.fragment_login

    override fun initData() {
        mFragmentBinding.shareViewModelLogin = shareViewModel
    }

    override fun initViews() {

    }

    override fun initActions() {

    }

    override fun initObserver() {
        observerNavigationWelcome()
    }

    private fun navigateToToWelcome() {
        //getNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }

    private fun observerNavigationWelcome() {
        shareViewModel.loginSuccess.observe(viewLifecycleOwner) {
            if (it) {
                navigateToToWelcome()
                shareViewModel.toComeWelcomeScreen()
            }
        }
    }

}