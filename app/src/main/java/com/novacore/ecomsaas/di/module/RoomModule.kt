package com.novacore.ecomsaas.di.module

import android.content.Context
import androidx.room.Room
import com.novacore.ecomsaas.db.EcomSaasDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RoomModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideDatabase(context : Context): EcomSaasDB{
        return Room.databaseBuilder(context.applicationContext,EcomSaasDB::class.java,"ecomsass.db").build()
    }
}