package erevacation.com.userlist_lifecycle.injection.builders

import dagger.Module
import dagger.android.ContributesAndroidInjector
import erevacation.com.userlist_lifecycle.injection.provider.FragmentProvider
import erevacation.com.userlist_lifecycle.ui.homescreen.HomeActivity
import erevacation.com.userlist_lifecycle.ui.homescreen.HomeActivityModule

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(HomeActivityModule::class), (FragmentProvider::class)])
    internal abstract fun bindHomeActivity(): HomeActivity

}