package erevacation.com.userlistlifecycle.ui.homescreen.list

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import erevacation.com.userlistlifecycle.datamodel.UserDM
import erevacation.com.userlistlifecycle.usecase.ListUC
import erevacation.com.userlistlifecycle.usecase.ListUCContract
import javax.inject.Inject

class ListFragmentViewModel @Inject constructor(val listUC: ListUC) : ViewModel(), ListUCContract.ListUCOut, ListContract.ListViewModel {


    init {
        listUC.setListUCOut(this)
    }

    override fun publishListResults(user: MutableList<UserDM>) {
        contacts.value = user
    }


    private lateinit var contacts: MutableLiveData<MutableList<UserDM>>
    fun getUsers(connected: Boolean): MutableLiveData<MutableList<UserDM>> {
        if (!::contacts.isInitialized) {
            contacts = MutableLiveData()
                listUC.getData(connected)
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