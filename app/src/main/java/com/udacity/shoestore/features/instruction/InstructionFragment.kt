package com.udacity.shoestore.features.instruction

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : BaseFragment<FragmentInstructionBinding>() {

    private val viewModel: InstructionViewmodel by viewModels()
    override fun getViewBinding() = R.layout.fragment_instruction

    override fun initData() {
        mFragmentBinding.instructionViewModel = viewModel
    }

    override fun initViews() {

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
        viewModel.toShoeListScreen.observe(viewLifecycleOwner) {
            if (it) {
                navigateToShoeList()
                viewModel.goToShoeListScreenComplete()
            }
        }
    }

}