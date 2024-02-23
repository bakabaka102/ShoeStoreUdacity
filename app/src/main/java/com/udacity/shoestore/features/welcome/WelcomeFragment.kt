package com.udacity.shoestore.features.welcome

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {

    private val viewModel: WelcomeViewModel by viewModels()

    override fun initData() {
        mFragmentBinding.welcomeViewModel = viewModel
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
        findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
    }

    private fun observerNavigationInstruction() {
        viewModel.toInstructionScreen.observe(viewLifecycleOwner) {
            if (it) {
                navigateToInstruction()
                viewModel.goToInstructionScreenComplete()
            }
        }
    }
}