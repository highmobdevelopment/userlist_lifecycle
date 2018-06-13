package erevacation.com.userlistlifecycle.ui.homescreen

import erevacation.com.userlistlifecycle.basic.arhitecture.CleanArchitectureContract

interface HomeContract {

    interface HomeView : CleanArchitectureContract.View {

    }

    interface HomeViewModel {
        fun buildLayout()
    }
}