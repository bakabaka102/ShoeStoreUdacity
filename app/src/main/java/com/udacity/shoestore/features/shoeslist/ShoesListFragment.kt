package com.udacity.shoestore.features.shoeslist

import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.databinding.LayoutItemShoeBinding
import com.udacity.shoestore.models.Shoe

class ShoesListFragment : BaseFragment<FragmentShoesListBinding>() {

    override fun getViewBinding() = R.layout.fragment_shoes_list


    override fun initData() {
        mFragmentBinding.shareViewModelShoesList = shareViewModel
    }

    override fun initViews() {

    }

    override fun initActions() {

    }

    override fun initObserver() {
        shareViewModel.shoesList.observe(viewLifecycleOwner) {
            bindShoeList(it)
        }
    }

    private fun bindShoeList(shoesList: MutableList<Shoe>) {
        val itemParent = mFragmentBinding.lnShoeItem
        //var index = 0
        for (shoe in shoesList) {
            val itemBinding: LayoutItemShoeBinding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.layout_item_shoe,
                itemParent,
                false
            )
            itemBinding.nameShoe.text = shoe.name
            itemBinding.descriptionShoe.text = shoe.company
            itemBinding.sizeShoe.text = shoe.size.toString()
            /*when (shoe.images[0]) {
                "model_0" -> itemBinding.imageShoe.setImageResource(R.drawable.ic_launcher_background)
                "model_1" -> itemBinding.imageShoe.setImageResource(R.drawable.ic_add)
                "model_2" -> itemBinding.imageShoe.setImageResource(R.drawable.model_2)
                "model_3" -> itemBinding.imageShoe.setImageResource(R.drawable.model_3)
                "model_4" -> itemBinding.imageShoe.setImageResource(R.drawable.model_4)
                "model_5" -> itemBinding.imageShoe.setImageResource(R.drawable.model_5)
            }*/
            itemParent.addView(itemBinding.root)
        }
        /*while (index < shoesList.size) {
            val itemBinding: LayoutItemShoeBinding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.layout_item_shoe,
                itemParent,
                false
            )
            val shoe = shoesList[index]
            itemBinding.nameShoe.text = shoe.name
            itemBinding.descriptionShoe.text = shoe.company
            itemBinding.sizeShoe.text = shoe.size.toString()
            *//*when (shoe.images[0]) {
                "model_0" -> itemBinding.imageShoe.setImageResource(R.drawable.ic_launcher_background)
                "model_1" -> itemBinding.imageShoe.setImageResource(R.drawable.ic_add)
                "model_2" -> itemBinding.imageShoe.setImageResource(R.drawable.model_2)
                "model_3" -> itemBinding.imageShoe.setImageResource(R.drawable.model_3)
                "model_4" -> itemBinding.imageShoe.setImageResource(R.drawable.model_4)
                "model_5" -> itemBinding.imageShoe.setImageResource(R.drawable.model_5)
            }*//*
            itemParent.addView(itemBinding.root)
            index++
        }*/
    }

}