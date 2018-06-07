package erevacation.com.userlist_lifecycle.ui.homescreen

import erevacation.com.userlist_lifecycle.basic.arhitecture.ViperContract

interface HomeContract {

    interface HomeView : ViperContract.View<HomePresenter> {

    }

    interface HomePresenter : ViperContract.Presenter {
        fun buildLayout()
    }
}