package com.novacore.ecomsaas.datasource.local

import androidx.lifecycle.LiveData
import com.novacore.ecomsaas.db.entity.ProductEntity
import com.novacore.ecomsaas.models.ListProduct

interface LocInterface{
    fun getFlashSaleHomeData() :LiveData<List<ListProduct>>
    fun getFeaturedProductsHomeData() : LiveData<List<ListProduct>>
    fun getRandomSamplesHomeData() : LiveData<List<ListProduct>>
    suspend fun  saveHomeData(products : List<ProductEntity>)
}