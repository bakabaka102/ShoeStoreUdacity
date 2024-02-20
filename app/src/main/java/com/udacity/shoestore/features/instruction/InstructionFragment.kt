package com.udacity.shoestore.features.instruction

import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.features.welcome.WelcomeFragmentDirections

class InstructionFragment : BaseFragment<FragmentInstructionBinding>() {

    private val viewmodel: InstructionViewmodel by viewModels()
    override fun getViewBinding() = R.layout.fragment_instruction

    override fun initData() {
        mFragmentBinding.instructionViewModel = viewmodel
    }

    override fun initViews() {
        (this.activity as MainActivity).findViewById<Toolbar>(R.id.toolbar).title =
            this.javaClass.simpleName
    }

    override fun initActions() {

    }

    override fun initObserver() {
        observerNavigationToShoeList()
    }

    private fun navigateToShoeList() {
        findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoesListFragment())
    }

    private fun observerNavigationToShoeList() {
        viewmodel.toShoeListScreen.observe(viewLifecycleOwner) {
            if (it) {
                navigateToShoeList()
                viewmodel.goToShoeListScreenComplete()
            }
        }
    }

}