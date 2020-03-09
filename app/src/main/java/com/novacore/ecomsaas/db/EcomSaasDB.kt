package com.novacore.ecomsaas.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.novacore.ecomsaas.db.dao.CartDao
import com.novacore.ecomsaas.db.entity.CartEntity

@Database(entities = [CartEntity::class], version = 1, exportSchema = false)
abstract class EcomSaasDB : RoomDatabase(){

    abstract fun cartDao() : CartDao

}