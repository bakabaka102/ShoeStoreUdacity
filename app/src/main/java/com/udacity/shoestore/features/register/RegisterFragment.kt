package com.udacity.shoestore.features.register

import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentRegisterBinding

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    private val viewModel: RegisterViewModel by viewModels()

    override fun getViewBinding() = R.layout.fragment_register

    override fun initData() {
        mFragmentBinding.registerViewModel = viewModel
    }

    override fun initViews() {
        (this.activity as MainActivity).findViewById<Toolbar>(R.id.toolbar).title =
            this.javaClass.simpleName
    }

    override fun initActions() {

    }

    override fun initObserver() {
        observerNavigationWelcome()
    }

    private fun observerNavigationWelcome() {
        viewModel.registerSuccess.observe(viewLifecycleOwner) {
            if (it) {
                navigateToToWelcome()
                viewModel.toComeWelcomeScreen()
            }
        }
    }

    private fun navigateToToWelcome() {
        findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToWelcomeFragment())
    }

}