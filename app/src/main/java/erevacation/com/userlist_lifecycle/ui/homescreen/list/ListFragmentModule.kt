package erevacation.com.userlist_lifecycle.ui.homescreen.list

import android.content.Context
import dagger.Module
import dagger.Provides
import erevacation.com.userlist_lifecycle.usecase.ListUC
import javax.inject.Named

@Module
abstract class ListFragmentModule {

    private lateinit var listUC: ListUC
    @Provides
    internal fun provideListViewModel(): ListContract.ListViewModel {
        return ListFragmentViewModel(listUC)
    }

    @Provides
    @Named("fragmentContext")
    fun provideFragmentContext(listFragment: ListFragment): Context? {
        return listFragment.context
    }
}