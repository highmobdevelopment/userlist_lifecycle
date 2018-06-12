package erevacation.com.userlist_lifecycle.ui.homescreen.profile

import android.content.Context
import dagger.Module
import dagger.Provides
import erevacation.com.userlist_lifecycle.ui.homescreen.list.ListContract
import erevacation.com.userlist_lifecycle.ui.homescreen.list.ListFragment
import erevacation.com.userlist_lifecycle.ui.homescreen.list.ListFragmentViewModel
import erevacation.com.userlist_lifecycle.usecase.ListUC
import javax.inject.Named

@Module
class ProfileFragmentModule {

    @Provides
    internal fun provideProfileViewModel():ProfileContract.ProfileViewModel {
        return ProfileFragmentViewModel()
    }

    @Provides
    @Named("fragmentContext")
    fun provideFragmentContext(profileFragment: ProfileFragment): Context? {
        return profileFragment.context
    }

}