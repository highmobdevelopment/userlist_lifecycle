package erevacation.com.userlistlifecycle.ui.homescreen.list

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import erevacation.com.userlistlifecycle.datamodel.ListDM
import erevacation.com.userlistlifecycle.usecase.ListUC
import erevacation.com.userlistlifecycle.usecase.ListUCContract
import javax.inject.Inject

class ListFragmentViewModel @Inject constructor(val listUC: ListUC) : ViewModel(), ListUCContract.ListUCOut, ListContract.ListViewModel {

init {
    listUC.setListUCOut(this)
}
    override fun publishListResults(list: MutableList<ListDM>) {
        contacts.value = list
    }

    private lateinit var contacts: MutableLiveData<MutableList<ListDM>>
    fun getUsers(): MutableLiveData<MutableList<ListDM>> {
        if (!::contacts.isInitialized) {
            contacts = MutableLiveData()
            listUC.getList()
        }
        return contacts
    }


    companion object {
        val NAME = "name"
        val SURNAME = "surname"
        val IMAGEURL = "image"
        val PROFILEINFOLIST = "profile_info_list"
    }

}