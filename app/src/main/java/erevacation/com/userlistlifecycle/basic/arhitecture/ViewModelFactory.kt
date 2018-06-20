package erevacation.com.userlistlifecycle.basic.arhitecture

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Lazy
import javax.inject.Inject

/**
 * Created by kojadin on 6/12/18.
 */
class ViewModelFactory<VM : ViewModel>
@Inject constructor(private val viewModel: Lazy<VM>) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <VM : ViewModel?> create(modelClass: Class<VM>): VM =
            viewModel.get() as VM
}