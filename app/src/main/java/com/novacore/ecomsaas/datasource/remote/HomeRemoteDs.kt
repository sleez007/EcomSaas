package com.novacore.ecomsaas.datasource.remote

import com.novacore.ecomsaas.network.response.HomeResponse
import com.novacore.ecomsaas.network.service.ApiService
import com.novacore.ecomsaas.util.Result

class HomeRemoteDs(private val apiService: ApiService) : RemInterface  {
    override suspend fun fetchHomeRemData(): Result<HomeResponse> {
        TODO("E neva reach")
    }
}