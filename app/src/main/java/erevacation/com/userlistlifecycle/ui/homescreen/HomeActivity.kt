package erevacation.com.userlistlifecycle.ui.homescreen

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import erevacation.com.userlistlifecycle.R
import erevacation.com.userlistlifecycle.basic.BasicActivity
import erevacation.com.userlistlifecycle.databinding.ActivityHomeBinding


class HomeActivity : BasicActivity<HomeActivityViewModel, ActivityHomeBinding>(), HomeContract.HomeView {
    private val TAG: String = HomeActivity::class.java.simpleName


    override fun getLayoutId(): Int = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewModel = ViewModelProviders.of(this).get(HomeActivityViewModel::class.java)
        //viewModel?.getUsers()?.observe(this, Observer { user ->  binding!!.name.text = user})
        setNavGraph()
    }

    private fun setNavGraph() {
        val host: NavHostFragment = fragmentManager.
                findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment? ?: return
    }
}