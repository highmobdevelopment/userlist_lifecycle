package erevacation.com.userlistlifecycle.datamanager

import erevacation.com.userlistlifecycle.basic.arhitecture.CleanArchitectureContract
import erevacation.com.userlistlifecycle.datamodel.UserDM
import io.reactivex.Observable

interface ListDataManagerContract : CleanArchitectureContract.DataManager {

    fun getList(isOnline:Boolean): Observable<List<UserDM>>
}