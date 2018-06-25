package erevacation.com.userlistlifecycle.injection.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import erevacation.com.userlistlifecycle.injection.scopes.PerApplication
import erevacation.com.userlistlifecycle.room.UserDatabase

@Module
class AppModule {
    @Provides
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    internal fun provideUserDb(context: Context): UserDatabase {
        return UserDatabase.getInstance(context)
    }
}