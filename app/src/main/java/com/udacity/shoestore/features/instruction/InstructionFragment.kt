package com.udacity.shoestore.features.instruction

import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : BaseFragment<FragmentInstructionBinding>() {

    override fun getViewBinding() = R.layout.fragment_instruction

    override fun initData() {
        mFragmentBinding.shareViewModelInstruction = shareViewModel
    }

    override fun initViews() {

    }

    override fun initActions() {

    }

    override fun initObserver() {

    }


}