package erevacation.com.userlistlifecycle.injection.builders

import dagger.Module
import dagger.android.ContributesAndroidInjector
import erevacation.com.userlistlifecycle.injection.provider.FragmentProvider
import erevacation.com.userlistlifecycle.ui.homescreen.HomeActivity
import erevacation.com.userlistlifecycle.ui.homescreen.HomeActivityModule

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(HomeActivityModule::class), (FragmentProvider::class)])
    internal abstract fun bindHomeActivity(): HomeActivity

}