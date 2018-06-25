package erevacation.com.userlistlifecycle.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import erevacation.com.userlistlifecycle.datamodel.UserDM

@Database(entities = arrayOf(UserDM::class), version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDMDao(): UserDMDao

    companion object {
       private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            if (INSTANCE == null) {
                synchronized(UserDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            UserDatabase::class.java, "user.db")
                            .build()
                }
            }
            return INSTANCE!!
        }

    }
}