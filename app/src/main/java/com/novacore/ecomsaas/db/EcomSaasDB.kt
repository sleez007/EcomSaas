package com.novacore.ecomsaas.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.novacore.ecomsaas.db.dao.CartDao
import com.novacore.ecomsaas.db.dao.ProductDao
import com.novacore.ecomsaas.db.entity.CartEntity
import com.novacore.ecomsaas.db.entity.ProductEntity

@Database(entities = [CartEntity::class, ProductEntity::class], version = 1, exportSchema = false)
abstract class EcomSaasDB : RoomDatabase(){

    abstract fun cartDao() : CartDao
    abstract  fun productDao() : ProductDao

}