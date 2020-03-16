package com.novacore.ecomsaas.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "product_table", indices = [Index(value = ["product_id"], unique = true)])
data class ProductEntity (
    @PrimaryKey(autoGenerate = true)
    var _id : Long = 0L,

    @ColumnInfo(name = "product_name")
    var productName : String,

    @ColumnInfo(name = "product_qty")
    var productQty : Int,

    @ColumnInfo(name = "product_id")
    var productId : String = "",

    @ColumnInfo(name = "product_image")
    var productImg : String  = "",

    @ColumnInfo(name ="product_slide_imgs")
    var productSlide_imgs : String,

    @ColumnInfo(name = "db_sn")
    var dbsn: Long = 0L,

    @ColumnInfo(name = "product_trader_id")
    var productTraderId : String = "",

    @ColumnInfo(name = "product_discount")
    var productDiscount : Int = 0,

    @ColumnInfo(name = "product_price")
    var productPrice : Double = 0.0,

    @ColumnInfo(name = "main_parent_id")
    var mainParentId: String  = "",

    @ColumnInfo(name = "sub_parent_id")
    var subParentId : String = "",

    @ColumnInfo(name = "has_size")
    var hasSize : Boolean = false,

    @ColumnInfo(name = "product_size")
    var productSizes : String = "",

    @ColumnInfo(name = "has_colors")
    var has_colors : Boolean = false,

    @ColumnInfo(name = "product_colors")
    var productColors : String = "",

    @ColumnInfo(name = "product_description")
    var productDescription : String = "",

    @ColumnInfo(name = "no_of_reviews")
    var noOfReview : Int = 0,

    @ColumnInfo(name =  "average_rating")
    var averageRating : Double = 0.0

)