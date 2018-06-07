package erevacation.com.userlist_lifecycle.ui.homescreen

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.os.PersistableBundle
import erevacation.com.userlist_lifecycle.R
import erevacation.com.userlist_lifecycle.basic.BasicActivity
import erevacation.com.userlist_lifecycle.databinding.ActivityHomeBinding
import android.arch.lifecycle.ViewModelProviders




class HomeActivity : BasicActivity<HomeActivityViewModel, ActivityHomeBinding>(), HomeContract.HomeView {
    private val TAG: String = HomeActivity::class.java.simpleName


    override fun getLayoutId(): Int = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeActivityViewModel::class.java)
        viewModel?.getUsers()?.observe(this, Observer { user ->  binding!!.name.text = user})
    }
    
}