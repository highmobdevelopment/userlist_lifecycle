package erevacation.com.userlistlifecycle.basic

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import erevacation.com.userlistlifecycle.basic.arhitecture.CleanArchitectureContract

abstract class BasicFragment<VM : ViewModel, B : ViewDataBinding> : Fragment(), CleanArchitectureContract.View {

    var binding: B? = null
    protected lateinit var viewModel: VM

    abstract fun getLayoutId(): Int

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindLayout(inflater, container)
        return binding?.root
    }


    private fun bindLayout(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
    }

    protected inline fun <reified VM : ViewModel> getViewModel(
            viewModelFactory: ViewModelProvider.Factory
    ): VM =
            ViewModelProviders.of(this, viewModelFactory)[VM::class.java]
}
