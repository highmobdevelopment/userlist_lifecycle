package erevacation.com.userlist_lifecycle.datamanager

import erevacation.com.userlist_lifecycle.basic.arhitecture.CleanArchitectureContract
import erevacation.com.userlist_lifecycle.datamodel.ListDM
import io.reactivex.Observable

interface ListDataManagerContract : CleanArchitectureContract.DataManager {

    fun getList(): Observable<MutableList<ListDM>>
}