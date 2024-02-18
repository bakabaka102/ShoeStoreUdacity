package com.udacity.shoestore.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import com.udacity.shoestore.shareviewmodel.ShareViewModel

abstract class BaseFragment<VB : ViewDataBinding> : Fragment(), IBaseFragment {

    val shareViewModel : ShareViewModel by activityViewModels()

    private var _mFragmentBinding: VB? = null
    val mFragmentBinding: VB get() = _mFragmentBinding!!

    fun getNavController(): NavController? = (activity as? BaseActivity<*>)?.getNavController()

    fun hideToolbar() {
        (activity as BaseActivity<*>).supportActionBar?.hide()
    }

    abstract fun getViewBinding(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_base, container, false)
        _mFragmentBinding = DataBindingUtil.inflate(inflater, getViewBinding(), container, false)
        initData()
        initViews()
        initActions()
        initObserver()
        return _mFragmentBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _mFragmentBinding = null
    }

}