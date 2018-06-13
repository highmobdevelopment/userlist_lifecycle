package erevacation.com.userlistlifecycle.ui.homescreen.profile

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import erevacation.com.userlistlifecycle.R
import erevacation.com.userlistlifecycle.basic.BasicFragment
import erevacation.com.userlistlifecycle.basic.arhitecture.ViewModelFactory
import erevacation.com.userlistlifecycle.databinding.FragmentProfileBinding
import erevacation.com.userlistlifecycle.datamodel.ListDM
import erevacation.com.userlistlifecycle.ui.homescreen.list.ListFragmentViewModel
import javax.inject.Inject

class ProfileFragment : BasicFragment<ProfileFragmentViewModel, FragmentProfileBinding>(), ProfileContract.ProfileView {
    var name: String? = ""
    var surname: String? = ""
    var imageUrl: String? = ""
    var profileListInfo: ArrayList<String>? = arrayListOf()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<ProfileFragmentViewModel>
    private val profileAdapter = ProfileRecyclerAdapter()

    override fun getLayoutId(): Int = R.layout.fragment_profile

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initializeUserInfo()
        viewModel = getViewModel(viewModelFactory)
        viewModel.getUserInfo(name, surname, imageUrl, profileListInfo).observe(this, Observer { info ->
            setUserNameAndImage(info)
        })
        buildLayout()
        setChronometer()
    }

    fun setChronometer(){
        if (viewModel.getStartTime() == null) {
            // If the start date is not defined, it's a new ViewModel so set it.
            val startTime = SystemClock.elapsedRealtime()
            viewModel.setStartTime(startTime)
            binding?.chronometer?.setBase(startTime)
        } else {
            // Otherwise the ViewModel has been retained, set the chronometer's base to the original
            // starting time.
            binding?.chronometer?.setBase(viewModel.getStartTime()!!)
        }

        binding?.chronometer?.start()
    }

    private fun buildLayout() {
        binding?.profileRecyclerView?.layoutManager = LinearLayoutManager(binding?.root?.context)
        binding?.profileRecyclerView?.adapter = profileAdapter
    }

    fun initializeUserInfo() {
        name = arguments?.getString(ListFragmentViewModel.NAME)
        surname = arguments?.getString(ListFragmentViewModel.SURNAME)
        imageUrl = arguments?.getString(ListFragmentViewModel.IMAGEURL)
        profileListInfo = arguments?.getStringArrayList(ListFragmentViewModel.PROFILEINFOLIST)

    }

    private fun setUserNameAndImage(info: ListDM?) {
        val fullName: String = "${info?.name} ${info?.surname}"
        binding?.name?.text = fullName
        binding?.profileImage?.let { Glide.with(binding!!.root.context).load(info?.image).apply(RequestOptions.circleCropTransform()).into(it) }
        val contactDetails = arrayListOf<String>(info?.contactDetails?.email ?: ""
                , info?.contactDetails?.address ?: ""
                , info?.contactDetails?.phones?.home ?: ""
                , info?.contactDetails?.phones?.work ?: "")
        profileAdapter.updateUserDetails(contactDetails)
    }
}