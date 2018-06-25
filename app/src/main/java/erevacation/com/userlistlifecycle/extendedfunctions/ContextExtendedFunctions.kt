package erevacation.com.userlistlifecycle.extendedfunctions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log


/**
 * Created by kojadin on 12/22/17.
 */

fun Context.isConnected(): Boolean {
    try {
        val connManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val wifi = connManager.activeNetworkInfo.state
        return wifi == NetworkInfo.State.CONNECTED
    } catch (e: Exception) {
        Log.e("ContextExtendedFun", "Context.isConnected()", e)
        return false
    }
}
