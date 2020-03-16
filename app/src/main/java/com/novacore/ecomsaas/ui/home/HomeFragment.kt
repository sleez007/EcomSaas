package com.novacore.ecomsaas.ui.home

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.novacore.ecomsaas.MainActivity
import com.novacore.ecomsaas.R
import com.novacore.ecomsaas.adapter.recycler.ProductFullHrAdapter
import com.novacore.ecomsaas.adapter.recycler.ProductHrAdapter
import com.novacore.ecomsaas.databinding.FragmentHomeBinding
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

class HomeFragment : DaggerFragment() {
    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory

    @Inject
    lateinit var arrivalAdapter : ProductHrAdapter

    @Inject
    lateinit var flashAdapter : ProductHrAdapter

    @Inject
    lateinit var randomAdapter : ProductFullHrAdapter

    lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater,container,false)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (activity as MainActivity).toggleNav(binding.toolbar)
        setHasOptionsMenu(true)
        homeViewModel =
            ViewModelProvider(this,providerFactory).get(HomeViewModel::class.java)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner= viewLifecycleOwner
        setUpAdapter()
    }
    private fun setUpAdapter(){
        binding.apply {
            arrivalRecycler.adapter = arrivalAdapter
            flashRecycler.adapter = flashAdapter
            randomRecycler.adapter = randomAdapter
        }

        homeViewModel.apply {
            arrivalData.observe(viewLifecycleOwner, Observer { it?.let { arrivalAdapter.submitList(it) } })
            flashData.observe(viewLifecycleOwner, Observer { it?.let { flashAdapter.submitList(it) } })
            randomData.observe(viewLifecycleOwner, Observer { it?.let { randomAdapter.submitList(it) } })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return  when(item.itemId) {
            R.id.action_search ->{
                Timber.i("Search Button Clicked")
                true
            }

            else ->super.onOptionsItemSelected(item)
        }
    }
}