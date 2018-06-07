package erevacation.com.userlist_lifecycle.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import erevacation.com.userlist_lifecycle.MainActivity
import erevacation.com.userlist_lifecycle.injection.builders.ActivityBuilder
import erevacation.com.userlist_lifecycle.injection.modules.AppModule
import erevacation.com.userlist_lifecycle.injection.modules.NetModule


@Component(modules = [(AndroidInjectionModule::class)
          ,(AppModule::class)
          ,(NetModule::class)
          ,(ActivityBuilder::class)])

interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MainActivity)
}
