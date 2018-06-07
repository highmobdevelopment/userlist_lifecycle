package erevacation.com.userlist_lifecycle.ui.homescreen

import android.os.Bundle
import android.os.PersistableBundle
import erevacation.com.userlist_lifecycle.R
import erevacation.com.userlist_lifecycle.basic.BasicActivity
import erevacation.com.userlist_lifecycle.databinding.ActivityHomeBinding


class HomeActivity : BasicActivity<HomeContract.HomePresenter, ActivityHomeBinding>(), HomeContract.HomeView {
    private val TAG: String = HomeActivity::class.java.simpleName


    override fun getLayoutId(): Int = R.layout.activity_home
    
}