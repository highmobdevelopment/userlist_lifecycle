package erevacation.com.userlistlifecycle.ui.homescreen.list

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import erevacation.com.userlistlifecycle.R
import erevacation.com.userlistlifecycle.basic.BasicFragment
import erevacation.com.userlistlifecycle.basic.arhitecture.ViewModelFactory
import erevacation.com.userlistlifecycle.databinding.FragmentListBinding
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