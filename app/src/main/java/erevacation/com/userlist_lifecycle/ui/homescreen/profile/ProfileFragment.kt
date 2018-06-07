//package erevacation.com.userlist_lifecycle.ui.homescreen.profile
//
//import erevacation.com.userlist_lifecycle.R
//import erevacation.com.userlist_lifecycle.basic.BasicFragment
//import erevacation.com.userlist_lifecycle.databinding.FragmentProfileBinding
//import erevacation.com.userlist_lifecycle.ui.homescreen.list.ListFragmentPresenter
//
//class ProfileFragment : BasicFragment<ProfileContract.ProfilePresenter, FragmentProfileBinding>()
//        , ProfileContract.ProfileView {
//    var name: String? = ""
//    var surname: String? = ""
//    var imageUrl: String? = ""
//    var profileListInfo: ArrayList<String>? = arrayListOf()
//
//    override fun getLayoutId(): Int = R.layout.fragment_profile
//
//    override fun onStart() {
//        super.onStart()
//        name = arguments?.getString(ListFragmentPresenter.NAME)
//        surname = arguments?.getString(ListFragmentPresenter.SURNAME)
//        imageUrl = arguments?.getString(ListFragmentPresenter.IMAGEURL)
//        profileListInfo = arguments?.getStringArrayList(ListFragmentPresenter.PROFILEINFOLIST)
//    }
//}