package erevacation.com.userlist_lifecycle.ui.homescreen.list

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import erevacation.com.userlist_lifecycle.R
import erevacation.com.userlist_lifecycle.databinding.ViewHolderListBinding
import erevacation.com.userlist_lifecycle.datamodel.ListDM

class ListRecyclerAdapter()
    : RecyclerView.Adapter<ListRecyclerAdapter.ListViewHolder>() {

    private val listInfo: MutableList<ListDM> = mutableListOf()
    private val profileInfoList: ArrayList<String> = arrayListOf()


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindList(listInfo[position].name,
                listInfo[position].surname,
                listInfo[position].image)

        holder.binding.listFragmentCard.setOnClickListener {
            this.profileInfoList.clear()
            this.profileInfoList.add(listInfo[position].contactDetails.email)
            this.profileInfoList.add(listInfo[position].contactDetails.address)
            this.profileInfoList.add(listInfo[position].contactDetails.phones.home)
            this.profileInfoList.add(listInfo[position].contactDetails.phones.work)

            openProfileScreen(listInfo[position].name
                    , listInfo[position].surname
                    , listInfo[position].image
                    , profileInfoList
                    , it)
        }
    }

    fun openProfileScreen(name: String, surname: String, image: String, profileInfoList: ArrayList<String>, view: View) {
        val bundle = Bundle()
        bundle.putString(ListFragmentViewModel.NAME, name)
        bundle.putString(ListFragmentViewModel.IMAGEURL, image)
        bundle.putString(ListFragmentViewModel.SURNAME, surname)
        bundle.putStringArrayList(ListFragmentViewModel.PROFILEINFOLIST, profileInfoList)
        Navigation.createNavigateOnClickListener(R.id.profileFragment, bundle)
        val options = NavOptions.Builder()
                .setEnterAnim(R.animator.right_in)
                .setExitAnim(R.animator.fui_slide_out_left)
                .setPopEnterAnim(R.animator.fui_slide_in_right)
                .setPopExitAnim(R.animator.right_out)
                .build()
        Navigation.findNavController(view).navigate(R.id.profileFragment, bundle, options)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ViewHolderListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listInfo.size
    }

    fun updateList(contacts: MutableList<ListDM>) {
        this.listInfo.clear()
        this.listInfo.addAll(contacts)
        notifyDataSetChanged()
    }

    class ListViewHolder(binding: ViewHolderListBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding

        fun bindList(name: String, surname: String, url: String) {
            binding.listFragmentCard.setListApperance(name, surname, url)
        }
    }
}

