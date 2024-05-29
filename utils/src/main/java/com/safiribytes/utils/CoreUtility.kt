package com.safiribytes.utils
import  android.net.ConnectivityManager
import android.content.Context
import android.net.NetworkCapabilities

object CoreUtility {
    fun  isInternetConnected(context: Context) : Boolean {
        var connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var networkCapabilities = connectivityManager.activeNetwork ?: return  false
        val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        val result = when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
        return  result
    }
}