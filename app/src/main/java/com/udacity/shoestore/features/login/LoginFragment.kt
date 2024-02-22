package com.udacity.shoestore.features.login

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel: LoginViewModel by viewModels()

    override fun getViewBinding() = R.layout.fragment_login

    override fun initData() {
        mFragmentBinding.loginViewModel = viewModel
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

    private fun navigateToToWelcome() {
        //getNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }

    private fun observerNavigationWelcome() {
        viewModel.loginSuccess.observe(viewLifecycleOwner) {
            if (it) {
                navigateToToWelcome()
                viewModel.toComeWelcomeScreen()
            }
        }
    }

}