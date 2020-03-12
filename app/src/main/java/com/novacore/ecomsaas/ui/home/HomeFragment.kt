package com.novacore.ecomsaas.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.novacore.ecomsaas.MainActivity
import com.novacore.ecomsaas.R
import com.novacore.ecomsaas.databinding.FragmentHomeBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment() {
    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory

    lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater,container,false)
        (activity as MainActivity).toggleNav(binding.toolbar)
        setHasOptionsMenu(true)
        homeViewModel =
            ViewModelProvider(this,providerFactory).get(HomeViewModel::class.java)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner= viewLifecycleOwner
    }
}