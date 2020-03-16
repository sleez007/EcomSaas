package com.novacore.ecomsaas.di.module

import android.content.Context
import android.content.SharedPreferences
import com.novacore.ecomsaas.datasource.local.HomeLocalDs
import com.novacore.ecomsaas.datasource.local.LocInterface
import com.novacore.ecomsaas.datasource.remote.HomeRemoteDs
import com.novacore.ecomsaas.datasource.remote.HomeRemoteTestDS
import com.novacore.ecomsaas.datasource.remote.RemInterface
import com.novacore.ecomsaas.db.EcomSaasDB
import com.novacore.ecomsaas.di.annotation.FakeSource
import com.novacore.ecomsaas.di.annotation.RealSource
import com.novacore.ecomsaas.helper.SharedPrefHelper
import com.novacore.ecomsaas.network.service.ApiService
import com.novacore.ecomsaas.repo.AppRepo
import com.novacore.ecomsaas.repo.AppRepoImp
import com.novacore.ecomsaas.repo.FakeAppRepo
import com.novacore.ecomsaas.util.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module(includes = [ApplicationModuleBinds::class])
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @JvmStatic
    @Singleton
    @Provides
    fun provideSharedPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences(Constants.APP, Context.MODE_PRIVATE)
    }

    @Singleton
    @JvmStatic
    @Provides
    @RealSource
    fun provideHomeLocalDs(db: EcomSaasDB, ioDispatcher: CoroutineDispatcher, sharedPreferences: SharedPrefHelper): LocInterface {
        return HomeLocalDs(db,ioDispatcher,sharedPreferences)
    }

    @Singleton
    @JvmStatic
    @Provides
    @RealSource
    fun provideHomeRemoteDs(apiService: ApiService): RemInterface {
        return HomeRemoteDs(apiService)
    }

    @Singleton
    @JvmStatic
    @Provides
    @FakeSource
    fun provideHomeRemoteFakeDs(): RemInterface {
        return HomeRemoteTestDS()
    }
}

@Module
abstract class ApplicationModuleBinds{
    @Singleton
    @Binds
    @RealSource
    abstract fun bindRealAppRepo(repo : AppRepoImp ) : AppRepo

    @Singleton
    @Binds
    @FakeSource
    abstract fun bindFakeAppRepo(repo : FakeAppRepo) : AppRepo
}