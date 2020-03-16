package com.novacore.ecomsaas.datasource.local

import androidx.lifecycle.LiveData
import com.novacore.ecomsaas.db.EcomSaasDB
import com.novacore.ecomsaas.db.entity.ProductEntity
import com.novacore.ecomsaas.helper.SharedPrefHelper
import com.novacore.ecomsaas.models.ListProduct
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeLocalDs(private val db : EcomSaasDB, private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO, private val prefHelper: SharedPrefHelper) :  LocInterface {
    override fun getFlashSaleHomeData(): LiveData<List<ListProduct>> {
        return db.productDao().getFlashSalesProducts(8)
    }

    override fun getFeaturedProductsHomeData(): LiveData<List<ListProduct>> {
        return db.productDao().getNewArrivalProducts(8)
    }

    override fun getRandomSamplesHomeData(): LiveData<List<ListProduct>> {
        return  db.productDao().getRandomSamples(12)
    }

    override suspend fun saveHomeData(products: List<ProductEntity>) {
        withContext(ioDispatcher){
            db.productDao().saveBulk(products)
        }
    }

}