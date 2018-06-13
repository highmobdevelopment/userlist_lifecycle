package erevacation.com.userlistlifecycle.basic

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import erevacation.com.userlistlifecycle.basic.arhitecture.CleanArchitectureContract
import javax.inject.Inject

abstract class BasicActivity<VM: ViewModel, B: ViewDataBinding> : AppCompatActivity(),
        CleanArchitectureContract.View, HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    protected var viewModel: VM? = null
    var binding: B? = null

    abstract fun getLayoutId():Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        bindLayout()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    private fun bindLayout(){
        binding = DataBindingUtil.setContentView(this, getLayoutId())
    }

}
