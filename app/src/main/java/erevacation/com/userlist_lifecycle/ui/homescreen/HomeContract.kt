package erevacation.com.userlist_lifecycle.ui.homescreen

import erevacation.com.userlist_lifecycle.basic.arhitecture.CleanArchitectureContract

interface HomeContract {

    interface HomeView : CleanArchitectureContract.View {

    }

    interface HomeViewModel {
        fun buildLayout()
    }
}