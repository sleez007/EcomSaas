package com.novacore.ecomsaas.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.novacore.ecomsaas.MainActivity

import com.novacore.ecomsaas.R
import com.novacore.ecomsaas.databinding.FragmentCategoryBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CategoryFragment : DaggerFragment() {
    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory

    private lateinit var viewModel: CategoryViewModel

    private lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater,container,false)
        (activity as MainActivity).toggleNav(binding.toolbar)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, providerFactory).get(CategoryViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        // TODO: Use the ViewModel
    }

}
