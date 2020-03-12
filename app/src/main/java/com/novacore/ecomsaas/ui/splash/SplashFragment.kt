package com.novacore.ecomsaas.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.novacore.ecomsaas.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SplashFragment : DaggerFragment() {
    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory

    private lateinit var viewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_spash, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, providerFactory).get(SplashViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
