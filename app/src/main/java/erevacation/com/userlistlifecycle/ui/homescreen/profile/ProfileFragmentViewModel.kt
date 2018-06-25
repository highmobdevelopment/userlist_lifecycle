package erevacation.com.userlistlifecycle.ui.homescreen.profile

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import erevacation.com.userlistlifecycle.datamodel.UserDM
import javax.inject.Inject

class ProfileFragmentViewModel @Inject constructor() : ViewModel(),ProfileContract.ProfileViewModel {


    private lateinit var userDetails: MutableLiveData<UserDM>
    fun getUserInfo(name:String?,surname:String?,imageUrl:String?,details:ArrayList<String>?): MutableLiveData<UserDM> {
        if (!::userDetails.isInitialized) {
            userDetails = MutableLiveData()
            userDetails.value = UserDM(null,name ?:""
                    ,surname ?:""
                    ,imageUrl ?:""
                    ,UserDM.Details(details?.get(0) ?:""
                    ,UserDM.Details.Phones(details?.get(2) ?:""
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