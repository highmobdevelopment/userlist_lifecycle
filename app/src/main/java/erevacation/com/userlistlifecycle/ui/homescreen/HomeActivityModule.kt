package erevacation.com.userlistlifecycle.ui.homescreen

import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {
    @Provides
    internal fun provideHomePresenter(): HomeContract.HomeViewModel {
        return HomeActivityViewModel()
    }
}