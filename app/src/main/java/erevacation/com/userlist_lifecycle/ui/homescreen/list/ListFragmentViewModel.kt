package erevacation.com.userlist_lifecycle.ui.homescreen.list

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import erevacation.com.userlist_lifecycle.datamodel.ListDM
import erevacation.com.userlist_lifecycle.ui.homescreen.HomeContract
import erevacation.com.userlist_lifecycle.usecase.ListUC
import erevacation.com.userlist_lifecycle.usecase.ListUCContract
import javax.inject.Inject

class ListFragmentViewModel @Inject constructor(val listUC: ListUC) : ViewModel(), ListUCContract.ListUCOut,ListContract.ListViewModel {


    override fun publishListResults(list: MutableList<ListDM>) {
        contacts?.value?.addAll(list)
    }

    private var contacts: MutableLiveData<MutableList<ListDM>>? = null
    fun getUsers(): MutableLiveData<MutableList<ListDM>>? {
        if (contacts == null) {
            contacts = MutableLiveData()
            listUC.getList()
        }
        return contacts
    }

    override fun buildLayout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        val NAME = "name"
        val SURNAME = "surname"
        val IMAGEURL = "image"
        val PROFILEINFOLIST = "profile_info_list"
    }

}