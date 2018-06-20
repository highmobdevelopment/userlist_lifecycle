package erevacation.com.userlistlifecycle.usecase

import erevacation.com.userlistlifecycle.datamodel.ListDM

interface ListUCContract {
    fun getList()
    fun setListUCOut(ListUCOut: ListUCOut)
    fun clearRequests()
    interface ListUCOut {
        fun publishListResults(list: MutableList<ListDM>)
    }
}