package erevacation.com.userlistlifecycle.datamanager

import com.erevacation.networking.ApiService
import erevacation.com.userlistlifecycle.datamodel.UserDM
import erevacation.com.userlistlifecycle.room.UserDatabase
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class ListDataManager @Inject constructor(var apiService: ApiService, var userDb: UserDatabase) : ListDataManagerContract {

    override fun getList(isOnline: Boolean): Observable<List<UserDM>> {
        return if (isOnline) {
            apiService.getList()
                    .flatMapIterable { list -> list }
                    .map { item -> UserDM(item) }
                    .doOnNext { item -> userDb.userDMDao().insert(item) }
                    .toList()
                    .toObservable()
        } else {
            Observable.create<List<UserDM>> { response -> userDb.userDMDao().getAll()
                response.onNext(userDb.userDMDao().getAll())
                response.onComplete()}
        }
    }
}