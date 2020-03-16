package com.novacore.ecomsaas.models

import androidx.room.ColumnInfo

data class ListProduct(
   @ColumnInfo(name = "product_name")
   var productName : String = "",
   @ColumnInfo(name = "product_price")
   var productPrice : Double = 0.0,
   @ColumnInfo(name = "product_id")
   var productId : String = "",
   @ColumnInfo(name = "product_image")
   var productImg : String  = "",
   @ColumnInfo(name = "product_discount")
   var productDiscount : Int = 0
)