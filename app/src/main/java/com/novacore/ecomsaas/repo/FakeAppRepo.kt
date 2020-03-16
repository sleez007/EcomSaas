package com.novacore.ecomsaas.repo

import androidx.lifecycle.LiveData
import com.novacore.ecomsaas.datasource.local.LocInterface
import com.novacore.ecomsaas.datasource.remote.RemInterface
import com.novacore.ecomsaas.di.annotation.FakeSource
import com.novacore.ecomsaas.di.annotation.RealSource
import com.novacore.ecomsaas.models.ListProduct
import com.novacore.ecomsaas.network.response.HomeResponse
import com.novacore.ecomsaas.util.Result
import timber.log.Timber
import javax.inject.Inject

class FakeAppRepo @Inject constructor(@RealSource val localDs: LocInterface, @FakeSource val remoteDs : RemInterface ) : AppRepo {
    override fun getFlashSaleHomeData(): LiveData<List<ListProduct>> {
        return localDs.getFlashSaleHomeData()
    }

    override fun getFeaturedProductsHomeData():LiveData<List<ListProduct>> {
        return localDs.getFeaturedProductsHomeData()
    }

    override fun getRandomSamplesHomeData(): LiveData<List<ListProduct>>{
        return  localDs.getRandomSamplesHomeData()
    }

    override suspend fun fetchHomeRemData() {
       val data : Result<HomeResponse>  = remoteDs.fetchHomeRemData()
        when(data){
            is Result.Success ->{
                localDs.saveHomeData(data.data.list)
            }
            is Result.Error -> {

            }
            is Result.IsNoInternetError ->{

            }
        }
        Timber.i(data.toString())
    }
}