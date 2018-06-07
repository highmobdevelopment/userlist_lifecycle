package erevacation.com.userlist_lifecycle.ui.homescreen

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import javax.inject.Inject




class HomeActivityViewModel @Inject constructor() : ViewModel(), HomeContract.HomeViewModel {


    private var name: MutableLiveData<String>? = null
    fun getUsers(): LiveData<String>? {
        if (name == null) {
            name = MutableLiveData<String>()
            loadName()
        }
        return name
    }

    private fun loadName() {
        name?.value = "Milivoje"
    }


    override fun buildLayout() {

    }


}