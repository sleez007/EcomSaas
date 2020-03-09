package com.novacore.ecomsaas.network.interceptor

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.novacore.ecomsaas.internal.exceptions.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ConnectivityInterceptorImpl @Inject constructor(val context: Context) :
    ConnectivityInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isOnline()) throw  NoConnectivityException()
        return chain.proceed(chain.request())

    }

    private fun isOnline(): Boolean{
        val connectivityManager : ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M){
            val nw = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }else{
            val actNw = connectivityManager.activeNetworkInfo
            return  actNw != null && actNw.isConnected()
        }
        return networkInfo
    }
}