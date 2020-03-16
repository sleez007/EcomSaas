package com.novacore.ecomsaas.repo

import androidx.lifecycle.LiveData
import com.novacore.ecomsaas.datasource.local.LocInterface
import com.novacore.ecomsaas.datasource.remote.RemInterface
import com.novacore.ecomsaas.di.annotation.RealSource
import com.novacore.ecomsaas.models.ListProduct
import javax.inject.Inject

class AppRepoImp @Inject constructor(@RealSource val localDs: LocInterface, @RealSource val remoteDs : RemInterface) : AppRepo {
    override fun getFlashSaleHomeData(): LiveData<List<ListProduct>> {
        return localDs.getFlashSaleHomeData()
    }

    override fun getFeaturedProductsHomeData(): LiveData<List<ListProduct>> {
        return localDs.getFeaturedProductsHomeData()
    }

    override fun getRandomSamplesHomeData(): LiveData<List<ListProduct>>{
        return  localDs.getRandomSamplesHomeData()
    }

    override suspend fun fetchHomeRemData() {

    }
}