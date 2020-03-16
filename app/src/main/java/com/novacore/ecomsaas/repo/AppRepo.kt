package com.novacore.ecomsaas.repo

import androidx.lifecycle.LiveData
import com.novacore.ecomsaas.models.ListProduct

interface AppRepo {
    fun getFlashSaleHomeData() :LiveData<List<ListProduct>>
    fun getFeaturedProductsHomeData() : LiveData<List<ListProduct>>
    fun getRandomSamplesHomeData() : LiveData<List<ListProduct>>
    suspend fun fetchHomeRemData()

}