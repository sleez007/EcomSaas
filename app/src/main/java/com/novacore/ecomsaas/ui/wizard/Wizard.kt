package com.novacore.ecomsaas.ui.wizard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.novacore.ecomsaas.R

class Wizard : Fragment() {

    companion object {
        fun newInstance() = Wizard()
    }

    private lateinit var viewModel: WizardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wizard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WizardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
