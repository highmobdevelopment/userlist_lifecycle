package erevacation.com.userlist_lifecycle.ui.homescreen.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import erevacation.com.userlist_lifecycle.R
import erevacation.com.userlist_lifecycle.basic.BasicFragment
import erevacation.com.userlist_lifecycle.basic.arhitecture.ViewModelFactory
import erevacation.com.userlist_lifecycle.databinding.FragmentListBinding
import javax.inject.Inject

class ListFragment : BasicFragment<ListFragmentViewModel, FragmentListBinding>(), ListContract.ListView {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory<ListFragmentViewModel>
    private val listAdapter = ListRecyclerAdapter()

    override fun getLayoutId(): Int = R.layout.fragment_list

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = getViewModel(viewModelFactory)
        viewModel.getUsers().observe(this, Observer { user ->
            listAdapter.updateList(user ?: mutableListOf())
        })
        buildLayout()
    }

    private fun buildLayout() {
        binding?.listRecyclerView?.layoutManager = LinearLayoutManager(binding?.root?.context)
        binding?.listRecyclerView?.adapter = listAdapter
    }

}