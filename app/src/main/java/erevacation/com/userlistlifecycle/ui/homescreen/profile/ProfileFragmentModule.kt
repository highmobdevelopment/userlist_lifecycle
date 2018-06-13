package erevacation.com.userlistlifecycle.ui.homescreen.profile

import android.content.Context
import dagger.Module
import dagger.Provides
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