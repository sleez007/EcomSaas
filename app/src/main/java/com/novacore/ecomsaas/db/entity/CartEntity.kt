package com.novacore.ecomsaas.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_table")
data class CartEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="id")
    var id : Long = 0L,

    @ColumnInfo(name = "product_name")
    var productName : String = "",

    @ColumnInfo(name = "product_quantity")
    var productQuantity : String = ""

)
//TODO: ADD THE REMAINING FIELDS LATER WHEN WE GET TO USAGE