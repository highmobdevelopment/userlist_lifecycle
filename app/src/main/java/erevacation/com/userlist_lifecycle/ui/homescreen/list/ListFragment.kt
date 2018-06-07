package erevacation.com.userlist_lifecycle.ui.homescreen.list

import erevacation.com.userlist_lifecycle.R
import erevacation.com.userlist_lifecycle.basic.BasicFragment
import erevacation.com.userlist_lifecycle.databinding.FragmentListBinding

class ListFragment : BasicFragment<ListContract.ListPresenter, FragmentListBinding>(), ListContract.ListView {

    override fun getLayoutId(): Int = R.layout.fragment_list

}