package com.novacore.ecomsaas.network.response

import com.novacore.ecomsaas.db.entity.ProductEntity

data class HomeResponse (
    val code : Int,
    val list : List<ProductEntity>
)