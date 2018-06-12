package erevacation.com.userlist_lifecycle.injection.provider

import dagger.Module
import dagger.android.ContributesAndroidInjector
import erevacation.com.userlist_lifecycle.ui.homescreen.list.ListFragment
import erevacation.com.userlist_lifecycle.ui.homescreen.list.ListFragmentModule

@Module
abstract class FragmentProvider {

    @ContributesAndroidInjector(modules = [(ListFragmentModule::class)])
    abstract fun provideListFragmentFactory(): ListFragment

//    @ContributesAndroidInjector(modules = [(ProfileFragmentModule::class)])
//    abstract fun provideProfileFragmentFactory(): ProfileFragment

}