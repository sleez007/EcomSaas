package com.novacore.ecomsaas.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.novacore.ecomsaas.db.entity.ProductEntity
import com.novacore.ecomsaas.models.ListProduct

@Dao
interface ProductDao {
    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun saveBulk(products : List<ProductEntity>)

    @Query("SELECT  product_name , product_image, product_price, product_discount,product_id FROM product_table  ORDER BY db_sn DESC LIMIT :limitSize ")
    fun getNewArrivalProducts(limitSize : Int): LiveData<List<ListProduct>>

    @Query("SELECT  product_name , product_image, product_price, product_discount,product_id FROM product_table WHERE product_discount > 30  ORDER BY RANDOM() LIMIT :limitSize" )
    fun getFlashSalesProducts(limitSize : Int): LiveData<List<ListProduct>>

    @Query("SELECT  product_name , product_image, product_price, product_discount,product_id FROM product_table WHERE product_discount > 30  ORDER BY RANDOM() LIMIT :limitSize" )
    fun getRandomSamples(limitSize: Int): LiveData<List<ListProduct>>
}