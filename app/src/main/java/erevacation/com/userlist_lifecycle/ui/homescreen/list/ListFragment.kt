package erevacation.com.userlist_lifecycle.ui.homescreen.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import erevacation.com.userlist_lifecycle.R
import erevacation.com.userlist_lifecycle.basic.BasicFragment
import erevacation.com.userlist_lifecycle.databinding.FragmentListBinding

class ListFragment : BasicFragment<ListFragmentViewModel, FragmentListBinding>(), ListContract.ListView {


    val listAdapter = ListRecyclerAdapter()
    override fun getLayoutId(): Int = R.layout.fragment_list

    override fun onStart() {
        super.onStart()

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListFragmentViewModel::class.java)
        viewModel?.getUsers()?.observe(this, Observer { user ->
            listAdapter.updateList(user ?: mutableListOf())
        })
        buildLayout()
    }

    private fun buildLayout() {
        binding?.listRecyclerView?.layoutManager = LinearLayoutManager(binding?.root?.context)
        binding?.listRecyclerView?.adapter = listAdapter
    }

}