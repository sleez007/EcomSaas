package com.novacore.ecomsaas.helper

import android.content.SharedPreferences
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class SharedPrefHelper @Inject constructor(val sharedPreferences: SharedPreferences, val gson: Gson, private val defDispatcher : CoroutineDispatcher = Dispatchers.Main) {

}