package erevacation.com.userlistlifecycle.datamanager

import erevacation.com.userlistlifecycle.basic.arhitecture.CleanArchitectureContract
import erevacation.com.userlistlifecycle.datamodel.ListDM
import io.reactivex.Observable

interface ListDataManagerContract : CleanArchitectureContract.DataManager {

    fun getList(): Observable<MutableList<ListDM>>
}