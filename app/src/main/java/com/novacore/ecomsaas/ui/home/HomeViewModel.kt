package com.novacore.ecomsaas.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.novacore.ecomsaas.db.entity.ProductEntity
import com.novacore.ecomsaas.di.annotation.FakeSource
import com.novacore.ecomsaas.di.annotation.RealSource
import com.novacore.ecomsaas.models.ListProduct
import com.novacore.ecomsaas.repo.AppRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(@FakeSource val appRepo :AppRepo ) : ViewModel() {

    val arrivalData  : LiveData<List<ListProduct>> = appRepo.getFeaturedProductsHomeData()
    val flashData : LiveData<List<ListProduct>> = appRepo.getFlashSaleHomeData()
    val randomData : LiveData<List<ListProduct>> = appRepo.getRandomSamplesHomeData()


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    init {
        getNetworkData()
    }

    fun getNetworkData(){
        viewModelScope.launch {
            appRepo.fetchHomeRemData()
        }
    }


}