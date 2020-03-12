package com.novacore.ecomsaas.ui.favorites


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.novacore.ecomsaas.MainActivity
import com.novacore.ecomsaas.databinding.FragmentFavoriteBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FavoriteFragment : DaggerFragment() {
    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory

    private lateinit var viewModel: FavoriteViewModel

    private lateinit var binding : FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater,container,false)
        (activity as MainActivity).toggleNav(binding.toolbar)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, providerFactory).get(FavoriteViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
