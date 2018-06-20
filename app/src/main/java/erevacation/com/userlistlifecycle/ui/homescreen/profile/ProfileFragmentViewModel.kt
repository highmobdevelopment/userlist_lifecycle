package erevacation.com.userlistlifecycle.ui.homescreen.profile

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import erevacation.com.userlistlifecycle.datamodel.ListDM
import javax.inject.Inject

class ProfileFragmentViewModel @Inject constructor() : ViewModel(),ProfileContract.ProfileViewModel {


    private lateinit var userDetails: MutableLiveData<ListDM>
    fun getUserInfo(name:String?,surname:String?,imageUrl:String?,details:ArrayList<String>?): MutableLiveData<ListDM> {
        if (!::userDetails.isInitialized) {
            userDetails = MutableLiveData()
            userDetails.value = ListDM(name ?:""
                    ,surname ?:""
                    ,imageUrl ?:""
                    ,ListDM.Details(details?.get(0) ?:""
                    ,ListDM.Details.Phones(details?.get(2) ?:""
                    ,details?.get(3) ?:"")
                    ,details?.get(1) ?:""))
        }
        return userDetails
    }

    private var mStartTime: Long? = null

    fun getStartTime(): Long? {
        return mStartTime
    }

    fun setStartTime(startTime: Long) {
        this.mStartTime = startTime
    }



}