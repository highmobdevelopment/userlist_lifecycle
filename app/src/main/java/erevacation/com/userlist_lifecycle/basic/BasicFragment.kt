package erevacation.com.userlist_lifecycle.basic

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import erevacation.com.userlist_lifecycle.basic.arhitecture.CleanArchitectureContract
import javax.inject.Inject

abstract class BasicFragment <VM : ViewModel, B: ViewDataBinding> : Fragment(), CleanArchitectureContract.View {

    //@Inject
    protected var viewModel: VM? = null
    var binding: B? = null

    abstract fun getLayoutId():Int

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindLayout(inflater, container)
        return binding?.root
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    private fun bindLayout(inflater: LayoutInflater, container: ViewGroup?){
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
    }
}
