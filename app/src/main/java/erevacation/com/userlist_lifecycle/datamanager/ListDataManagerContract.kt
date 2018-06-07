package erevacation.com.userlist_lifecycle.datamanager

import erevacation.com.userlist_lifecycle.basic.arhitecture.ViperContract
import erevacation.com.userlist_lifecycle.datamodel.ListDM
import io.reactivex.Observable

interface ListDataManagerContract : ViperContract.DataManager {

    fun getList(): Observable<MutableList<ListDM>>
}