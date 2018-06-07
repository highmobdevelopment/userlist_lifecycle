package erevacation.com.userlist_lifecycle.usecase

import erevacation.com.userlist_lifecycle.datamodel.ListDM

interface ListUCContract {
    fun getList()
    fun setListUCOut(ListUCOut: ListUCOut)
    fun clearRequests()
    interface ListUCOut {
        fun publishListResults(list: MutableList<ListDM>)
    }
}