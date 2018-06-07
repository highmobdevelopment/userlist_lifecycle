package erevacation.com.userlist_lifecycle.ui.homescreen.profile

import erevacation.com.userlist_lifecycle.basic.arhitecture.ViperContract

interface ProfileContract {


    interface ProfileView : ViperContract.View<ProfilePresenter> {

    }

    interface ProfilePresenter : ViperContract.Presenter {

    }

}