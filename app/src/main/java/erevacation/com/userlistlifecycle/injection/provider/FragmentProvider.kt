package erevacation.com.userlistlifecycle.injection.provider

import dagger.Module
import dagger.android.ContributesAndroidInjector
import erevacation.com.userlistlifecycle.ui.homescreen.list.ListFragment
import erevacation.com.userlistlifecycle.ui.homescreen.list.ListFragmentModule
import erevacation.com.userlistlifecycle.ui.homescreen.profile.ProfileFragment
import erevacation.com.userlistlifecycle.ui.homescreen.profile.ProfileFragmentModule

@Module
abstract class FragmentProvider {

    @ContributesAndroidInjector(modules = [(ListFragmentModule::class)])
    abstract fun provideListFragmentFactory(): ListFragment

    @ContributesAndroidInjector(modules = [(ProfileFragmentModule::class)])
    abstract fun provideProfileFragmentFactory(): ProfileFragment

}