package com.novacore.ecomsaas.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.novacore.ecomsaas.di.annotation.MyInterceptor
import com.novacore.ecomsaas.network.interceptor.ConnectivityInterceptorImpl
import com.novacore.ecomsaas.network.service.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttp(@MyInterceptor connectivityInterceptorImpl: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(connectivityInterceptorImpl)
            .build()
    }

    @Singleton
    @Provides
    fun provideGSON(): Gson {
        return GsonBuilder().create()
    }

    //THE QUALIFIER PASSED HERE IS TO ENABLE US SWAPOUT DIFFERENT IMPLEMETATION OF INTERCEPTORS
    @Provides
    @MyInterceptor
    @Singleton
    fun provideConnectivityInterceptor(context: Context): Interceptor {
        return ConnectivityInterceptorImpl(context)
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttp: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl("http://192.168.43.205/mobv2/")
            .client(okHttp)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}