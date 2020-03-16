package com.novacore.ecomsaas.datasource.remote

import com.novacore.ecomsaas.network.response.HomeResponse
import com.novacore.ecomsaas.util.Result

interface RemInterface {
   suspend fun fetchHomeRemData(): Result<HomeResponse>
}