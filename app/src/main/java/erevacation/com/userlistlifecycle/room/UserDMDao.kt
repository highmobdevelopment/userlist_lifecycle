package erevacation.com.userlistlifecycle.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import erevacation.com.userlistlifecycle.datamodel.UserDM
import io.reactivex.Observable

@Dao
interface UserDMDao {
    @Query("SELECT * from users")
    fun getAll(): List<UserDM>

    @Insert(onConflict = REPLACE)
    fun insert(databaseDM: UserDM)

    @Query("DELETE from users")
    fun deleteAll()
}