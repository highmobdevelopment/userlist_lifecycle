package erevacation.com.userlist_lifecycle.ui.homescreen.list

import erevacation.com.userlist_lifecycle.basic.arhitecture.CleanArchitectureContract

interface ListContract {
    interface ListView : CleanArchitectureContract.View {

    }

    interface ListViewModel {
        fun buildLayout()
    }
}