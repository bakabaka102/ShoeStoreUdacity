package com.udacity.shoestore.features.register

import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentRegisterBinding

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    private val viewModel: RegisterViewModel by viewModels()
    private val mOnBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            activity?.finish()
        }
    }

    override fun getViewBinding() = R.layout.fragment_register

    override fun initData() {
        mFragmentBinding.registerViewModel = viewModel
    }

    override fun initViews() {
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (this.activity as MainActivity).findViewById<Toolbar>(R.id.toolbar)
            .title = this.javaClass.simpleName
    }

    override fun initActions() {
        activity?.onBackPressedDispatcher?.addCallback(this, mOnBackPressedCallback)
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