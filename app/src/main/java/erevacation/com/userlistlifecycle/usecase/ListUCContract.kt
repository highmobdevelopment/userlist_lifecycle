package erevacation.com.userlistlifecycle.usecase

import erevacation.com.userlistlifecycle.datamodel.UserDM

interface ListUCContract {
    fun getData(isConnected: Boolean)
    fun setListUCOut(ListUCOut: ListUCOut)
    fun clearRequests()
    interface ListUCOut {
        fun publishListResults(user: MutableList<UserDM>)
    }
}