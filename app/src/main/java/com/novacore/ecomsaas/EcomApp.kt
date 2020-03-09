package com.novacore.ecomsaas

import android.content.Context
import android.content.SharedPreferences
import com.novacore.ecomsaas.di.component.DaggerApplicationComponent
import com.novacore.ecomsaas.helper.ThemeHelper
import com.novacore.ecomsaas.util.Constants
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class EcomApp :DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        initializeTheme()
    }

    private fun initializeTheme(){
        val sharedPref: SharedPreferences = getSharedPreferences(Constants.APP, Context.MODE_PRIVATE)
        val theme = sharedPref.getString(resources.getString(R.string.preference_key_theme_option), Constants.THEME_DEFAULT)
        theme?.let {
            ThemeHelper.applyTheme(it)
        }
    }
}