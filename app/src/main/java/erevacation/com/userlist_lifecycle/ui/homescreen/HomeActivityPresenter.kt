package erevacation.com.userlist_lifecycle.ui.homescreen

import android.app.FragmentManager
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import androidx.navigation.fragment.NavHostFragment
import erevacation.com.userlist_lifecycle.R
import erevacation.com.userlist_lifecycle.basic.arhitecture.ViperContract
import erevacation.com.userlist_lifecycle.databinding.ActivityHomeBinding
import javax.inject.Inject


class HomeActivityPresenter @Inject constructor() : HomeContract.HomePresenter {


    private val TAG: String = "HomeActivityPresenter"
    private var view: HomeContract.HomeView? = null
    private var binding: ActivityHomeBinding? = null
    private lateinit var fragmentManager: FragmentManager

    // overrides that every presenter have
    override fun viewAttach(view: ViperContract.View<*>) {
        this.view = view as HomeContract.HomeView
        this.binding = (this.view as? HomeActivity)?.binding
        fragmentManager = (this.view as HomeActivity).fragmentManager
        buildLayout()
    }

    override fun viewDetach() {
        this.view = null
        this.binding = null
    }


    override fun onDestroyed() {
        this.view = null
        this.binding = null
    }

    override fun buildLayout() {
        val host: NavHostFragment = fragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment?
                ?: return
    }


}